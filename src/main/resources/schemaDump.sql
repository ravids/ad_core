drop table if exists UserGroup;
create table UserGroup (
  UserGroupID integer generated by default as identity(start with 1) primary key,
  ParentID integer NOT NULL ,
  LanguageTypeID integer DEFAULT NULL,
  ShortDescription varchar(100) DEFAULT NULL,
  LongDescription varchar(255) DEFAULT NULL,
  CompanyID integer DEFAULT NULL
);

DROP TABLE IF EXISTS CompanyLesson;
CREATE TABLE CompanyLesson (
  CompanyID integer NOT NULL,
  CourseID integer NOT NULL,
  CoCourseID integer NOT NULL,
  LessonID integer NOT NULL,
  TotalCategory1 integer,
  TotalCategory2 integer,
  TotalQuestions integer
);

DROP TABLE IF EXISTS UserGroupCourse;
CREATE TABLE UserGroupCourse (
  UserGroupID integer NOT NULL ,
  CoCourseID integer NOT NULL ,
  Passmark integer NOT NULL ,
  Frequency varchar(15) NOT NULL ,
  LastChangeUserID integer DEFAULT NULL,
  LastChangeDate date DEFAULT NULL,
  LastChangeTime time DEFAULT NULL,
  DeleteUserID integer DEFAULT NULL,
  DeleteDate datetime DEFAULT NULL
);

DROP TABLE IF EXISTS UserGroupLesson;
CREATE TABLE UserGroupLesson (
  LessonID integer NOT NULL,
  CoCourseID integer NOT NULL,
  UserGroupID integer NOT NULL,
  LanguageTypeID integer NOT NULL,
  StartDate varchar(15),
  Frequency varchar(15)
);

DROP TABLE IF EXISTS Lesson;
CREATE TABLE Lesson (
  CourseID integer NOT NULL ,
  LessonID integer NOT NULL ,
  LanguageTypeID integer NOT NULL ,
  LessonTypeID integer DEFAULT NULL,
  LessonCode char(3) DEFAULT NULL
);

DROP TABLE IF EXISTS Course;
CREATE TABLE Course (
  CourseID integer NOT NULL ,
  CourseName varbinary(255) DEFAULT NULL,
  CourseType integer NOT NULL ,
  ServiceID integer NOT NULL ,
  QuizBase integer NOT NULL ,
  Country varchar(2) NOT NULL
);

DROP TABLE IF EXISTS CompanyCourse;
CREATE TABLE CompanyCourse (
  CompanyID integer NOT NULL,
  CourseID integer NOT NULL,
  CoCourseID integer NOT NULL,
  CoCourseName varbinary(255),
  id integer generated by default as identity(start with 1) primary key
);


-- Initial values
insert into CompanyCourse (CompanyID,CoCourseID,CourseID) values ('410', '1', '3');
insert into Lesson (CourseID,LessonID,LanguageTypeID,LessonCode) values ('3', '1', '1', 'ABC');
