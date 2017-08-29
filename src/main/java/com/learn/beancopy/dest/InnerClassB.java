package com.learn.beancopy.dest;

import org.dozer.Mapping;

public class InnerClassB {

    @Mapping("classA")
    private ClassB classB;

    private String sex;


    public class ClassB {
        private String name;

        private double age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAge() {
            return age;
        }

        public void setAge(double age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "ClassB{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "InnerClassB{" +
                "classB=" + classB +
                ", sex='" + sex + '\'' +
                '}';
    }
}
