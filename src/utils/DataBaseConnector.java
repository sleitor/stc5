package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class DataBaseConnector  {

    public static Connection initConnection(){

        Connection connection = null;

        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection( "jdbc:mysql://sleitor.stc5.ru/students", "demo","q1w2e3r4" );
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void createTable(){

        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();


            statement.execute( "CREATE TABLE study_group ( id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255),  CONSTRAINT pk_study_group_id PRIMARY KEY (id) )ENGINE=InnoDB DEFAULT CHARSET=utf8;" );
            statement.execute( "CREATE TABLE student( id integer NOT NULL AUTO_INCREMENT, name varchar(255), age integer, group_id integer DEFAULT 0, CONSTRAINT pk_student_id PRIMARY KEY (id), CONSTRAINT fk_student__study_group FOREIGN KEY (group_id) REFERENCES study_group (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION )ENGINE=InnoDB DEFAULT CHARSET=utf8;" );
            statement.execute( "CREATE TABLE lesson ( id integer NOT NULL AUTO_INCREMENT, study_group_id integer NOT NULL, lesson_date date NOT NULL, room integer NOT NULL, description varchar(2000), CONSTRAINT fk_lesson PRIMARY KEY (id), CONSTRAINT fk_lesson_study_group FOREIGN KEY (study_group_id) REFERENCES study_group (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION )ENGINE=InnoDB DEFAULT CHARSET=utf8;" );
            statement.execute( "CREATE TABLE journal( id integer NOT NULL AUTO_INCREMENT, lesson_id integer NOT NULL, student_id integer NOT NULL, CONSTRAINT pk_journal_id PRIMARY KEY (id), CONSTRAINT fk_journal_lesson FOREIGN KEY (lesson_id) REFERENCES lesson (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION, CONSTRAINT fk_journal_student FOREIGN KEY (student_id) REFERENCES student (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION )ENGINE=InnoDB DEFAULT CHARSET=utf8;" );
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
            db.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable(){

        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            statement.execute( "DROP TABLE journal, lesson, student, study_group");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        finally {

        }
        try {
            db.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addGroup(String groupName) {
        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            statement.execute( "INSERT INTO `study_group`(`name`) VALUES ( '" + groupName + "' ); " );
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addGroups() {
        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            statement.execute( "INSERT INTO `study_group`(`name`) VALUES ( 'STC-1' ); " );
            statement.execute( "INSERT INTO `study_group`(`name`) VALUES ( 'STC-2' ); " );
            statement.execute( "INSERT INTO `study_group`(`name`) VALUES ( 'STC-3' ); " );
            statement.execute( "INSERT INTO `study_group`(`name`) VALUES ( 'STC-4' ); " );
            statement.execute( "INSERT INTO `study_group`(`name`) VALUES ( 'STC-5' ); " );
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent() {
        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Травин Исаия Абрамович','18','1' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Чернопятов Иммануил Никифорович','19','1' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Говоров Фофан Абакумович','20','1' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Есипович Ананий Корнилович','21','1' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Рындин Куприян Адамович','22','1' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Ипатьев Парамон Бенедиктович','22','2' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Харченко Хрисанф Аполлонович','22','2' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Купреянов Азарий Елисеевич','23','2' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Евсюков Аким Анисимович','23','2' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Лихопой Кириак Селивёрстович','24','3' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Шетнев Памфил Иерофеевич','25','3' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Невский Гордей Вавилич','26','3' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Ерлыков Александр Минеевич','26','4' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Акинфов Косма Арефьевич','26','4' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Безсонов Никита Яковлевич','23','4' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Ардабьев Ярмило Евстигнеевич','28','4' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Борщов Иустин Евгеньевич','24','5' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Водосвятский Христодул Ираклиевич','29','5' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Восьянов Вилен Феоктистович','21','5' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Брюхатов Акентий Мануилович','30','5' ) " );
            statement.execute( "INSERT INTO `student`(`name`, `age` , `group_id` ) VALUES ( 'Перекусихин Януарий Мстиславович','18','5' ) " );
        } catch(SQLException e) {
            e.printStackTrace();
        }


    }

    public static void addStudents(String name, String age, String group_id) {
        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();
            statement.execute( "INSERT INTO `study_group`(`name`, `age` , `group_id` ) VALUES ( '" + name + "','" + age + "','" + group_id + "' ) " );
        } catch(SQLException e) {
            e.printStackTrace();
        }


    }

    public static void addLessons() {
        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();

            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (1,'2017-04-01',301,'Введение в программироание');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (1,'2017-04-02',301,'Паттерны программирования');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (1,'2017-04-03',401,'Spring');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (1,'2017-04-04',401,'Система ввода вывода');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (1,'2017-04-05',501,'Многопоточность');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (2,'2017-04-01',501,'Введение в программироание');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (2,'2017-04-02',501,'Паттерны программирования');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (2,'2017-04-03',501,'Spring');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (2,'2017-04-04',501,'Система ввода вывода');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (2,'2017-04-05',320,'Многопоточность');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (3,'2017-04-01',320,'Введение в программироание');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (3,'2017-04-02',320,'Паттерны программирования');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (3,'2017-04-03',401,'Spring');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (3,'2017-04-04',401,'Система ввода вывода');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (3,'2017-04-05',401,'Многопоточность');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (4,'2017-04-01',401,'Введение в программироание');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (4,'2017-04-02',315,'Паттерны программирования');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (4,'2017-04-03',315,'Spring');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (4,'2017-04-04',315,'Система ввода вывода');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (4,'2017-04-05',420,'Многопоточность');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (5,'2017-04-01',420,'Введение в программироание');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (5,'2017-04-02',420,'Паттерны программирования');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (5,'2017-04-03',501,'Spring');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (5,'2017-04-04',401,'Система ввода вывода');" );
            statement.execute( "INSERT INTO `lesson`(`study_group_id`, `lesson_date`, `room`, `description`) VALUES (5,'2017-04-05',401,'Многопоточность');" );

        } catch(SQLException e) {
            e.printStackTrace();
        }


    }

    public static void addJournal() {
        Connection db = initConnection();
        try {
            Statement statement = db.createStatement();

            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('2','1')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('2','2')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('2','3')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('2','4')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('2','5')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('7','6')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('7','7')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('7','8')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('7','9')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('12','10')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('12','11')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('12','12')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('17','13')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('17','14')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('17','15')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('17','16')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('22','17')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('22','18')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('22','19')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('22','20')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('22','21')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('3','1')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('3','2')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('3','3')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('3','4')" );
            statement.execute( "INSERT INTO `journal`(`lesson_id`, `student_id`) VALUES ('3','5')" );

        } catch(SQLException e) {
            e.printStackTrace();
        }


    }


}