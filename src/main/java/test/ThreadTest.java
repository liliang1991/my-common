package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadTest {
    public static long between(String startTime, String endTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate s1 = LocalDate.parse(startTime, dtf);
        LocalDate s2 = LocalDate.parse(endTime, dtf);

        Period between = Period.between(s2, s1);
        return between.getDays();

    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user1 = new User("aa", "2019-03-11");
        User user2 = new User("bb", "2019-03-11");
        User user3 = new User("cc", "2019-03-12");
        User user4 = new User("aa", "2019-03-12");
        User user5 = new User("cc", "2019-03-11");
        User user6 = new User("aa", "2019-03-11");
        User user7 = new User("aa", "2019-03-13");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        String num = Integer.toBinaryString(1 << 10);
        Map<String,Integer> map=new HashMap<>();
        //map.put()
        //System.out.println(num);
        System.out.println(between("2019-03-13","2019-03-11"));
    }
}
