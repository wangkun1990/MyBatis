
CREATE TABLE student (
	`stu_id` INT (10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR (50) NOT NULL,
	`dep_id` INT (10) NOT NULL,
	`sex` CHAR (1) NOT NULL,
	PRIMARY KEY (stu_id),
	FOREIGN KEY (dep_id) REFERENCES dept(department_id)
); 
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('1','张三','1','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('2','李四','2','0');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('3','王五','2','0');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('4','赵六','1','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('5','tom','1','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('6','侯亮平','2','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('7','侯亮平','2','0');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('8','侯亮平','2','1');
