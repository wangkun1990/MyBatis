package com.learn.service.inner;

import com.learn.entity.TFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class IFileServiceTest {

    @Resource
    IFileService fileService;

    @Test
    public void testInsertFile() {
        try {
            org.springframework.core.io.Resource resource = new ClassPathResource("明朝那些事儿.txt");
            File file = resource.getFile();
            System.out.println(file.length());
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            in.read(bytes);
            TFile tFile = new TFile();
            tFile.setFile(bytes);
            fileService.insertFile(tFile);
        } catch (Exception e) {

        }

    }

    @Test
    public void testGetFile() {
        TFile tFile = fileService.getFile();
        System.err.println(tFile.getFile().length);
    }
}
