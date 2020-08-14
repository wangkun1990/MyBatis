package com.learn.tools;

import net.sf.oval.constraint.EqualToField;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.junit.Test;


public class ValidationUtilsTest {

    @Test
    public void validate() {
        Person person = new Person();
        person.setPassword("123");
        person.setComfirmPassWord("123");
        ValidationUtils.validate(person);
    }

    private static class Person {
        @NotNull(message = "密码不能为空")
        @NotBlank(message = "密码不能为空")
        private String password;

        @NotNull(message = "确认密码不能为空")
        @NotBlank(message = "确认密码不能为空")
        @EqualToField(value = "password", message = "确认密码和原密码不一致")
        private String comfirmPassWord;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getComfirmPassWord() {
            return comfirmPassWord;
        }

        public void setComfirmPassWord(String comfirmPassWord) {
            this.comfirmPassWord = comfirmPassWord;
        }
    }
}