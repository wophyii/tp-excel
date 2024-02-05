package cn.wophy;

import cn.wophy.dto.TestDto;
import cn.wophy.generate.ExcelTemplateGenerate;
import cn.wophy.view.ExcelTemplateView;
import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExcelTemplateTest {

    @Test
    public void getTemplateView() {
        List<ExcelTemplateView> templateView = ExcelTemplateGenerate.getTemplateView(TestDto.class);

    }


    @Test
    public void generateTemplate() {
        List<ExcelTemplateView> templateView = ExcelTemplateGenerate.getTemplateView(TestDto.class);
        File file = ExcelTemplateGenerate.generateTemplate(templateView);
    }

    @Test
    public void writeWithTemplate() {
        List<ExcelTemplateView> templateView = ExcelTemplateGenerate.getTemplateView(TestDto.class);
        File file = ExcelTemplateGenerate.generateTemplate(templateView);
        EasyExcel.write(new File(System.currentTimeMillis()+".xlsx"))
                .withTemplate(file)
                .sheet()
                .doFill(dtos());

    }


    public ArrayList<TestDto> dtos(){
        ArrayList<TestDto> testDtos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testDtos.add(new TestDto("name-" + i, i));
        }
        return testDtos;
    }
}
