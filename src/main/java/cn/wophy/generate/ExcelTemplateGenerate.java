package cn.wophy.generate;

import cn.wophy.exception.ExcelTemplateException;
import cn.wophy.view.ExcelTemplateView;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;


import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExcelTemplateGenerate {


    public static File generateTemplate(List<ExcelTemplateView> excelTemplateViews) {

        if (excelTemplateViews == null || excelTemplateViews.isEmpty()) {
            throw new ExcelTemplateException("excel view con not null");
        }
        List<List<String>> head = new ArrayList<>();
        List<List<String>> data = new ArrayList<>();
        ArrayList<String> attribute = new ArrayList<>();
        for (ExcelTemplateView excelTemplateView : excelTemplateViews) {
            List<String> strings = new ArrayList<>();
            strings.add(excelTemplateView.getTitle());
            head.add(strings);
            attribute.add("{." + excelTemplateView.getAttribute() + "}");
        }
        data.add(attribute);
        File file = new File(UUID.randomUUID().toString()+".xlsx");
        EasyExcel.write(file)
                .head(head).sheet()
                .doWrite(data);
        return file;
    }


    public static File generateTemplate(String fileName, List<ExcelTemplateView> excelTemplateViews) {
        if (excelTemplateViews == null || excelTemplateViews.isEmpty()) {
            throw new ExcelTemplateException("excel view con not null");
        }
        List<List<String>> head = new ArrayList<>();
        List<List<String>> data = new ArrayList<>();
        ArrayList<String> attribute = new ArrayList<>();
        for (ExcelTemplateView excelTemplateView : excelTemplateViews) {
            List<String> strings = new ArrayList<>();
            strings.add(excelTemplateView.getTitle());
            head.add(strings);
            attribute.add("{." + excelTemplateView.getAttribute() + "}");
        }
        data.add(attribute);
        File file = new File(fileName.endsWith(".xlsx")?fileName:fileName+".xlsx");
        EasyExcel.write(file)
                .head(head).sheet()
                .doWrite(data);
        return file;
    }

    public static List<ExcelTemplateView> getTemplateView(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<ExcelTemplateView> templateMap = new ArrayList<>();
        for (Field field : fields) {
            ExcelProperty annotation = field.getAnnotation(ExcelProperty.class);
            if (annotation != null) {
                String[] value = annotation.value();
                ExcelTemplateView excelTemplateView = new ExcelTemplateView(value[0], field.getName());
                templateMap.add(excelTemplateView);
            }
        }
        return templateMap;
    }
}
