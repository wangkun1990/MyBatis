package com.learn.beancopy.source;

public class InnerClassA {

    private ClassA classA;

    private long sex;

    public class ClassA {
        private String name;

        private long age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getAge() {
            return age;
        }

        public void setAge(long age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "ClassA{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public ClassA getClassA() {
        return classA;
    }

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }

    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "InnerClassA{" +
                "classA=" + classA +
                ", sex=" + sex +
                '}';
    }
}
