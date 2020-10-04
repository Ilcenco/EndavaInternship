package InternshipTask;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        //next 7 lines there will be some data we will use randomly to create users;
        String[] fname = {"John", "Mark", "Bob", "Alice", "Ann", "Tom", "Sam", "Dean", "Casper"};
        String[] lname = {"Winchester", "Marley", "Cooper", "Lee", "Jonhson", "Smeichel"};
        int[] ages = {22, 23, 34, 45, 11, 32, 66, 35, 58, 31, 21, 18};
        String[] uStatus = {"New", "Active", "Inactive", "Blocked"};
        String email;
        String r_fname, r_lname, r_uStatus;
        int r_ages, random_seconds;

        ArrayList<User> list = new ArrayList(); //here we will stock the list of Users

        Timestamp yesterday = Timestamp.from(Instant.now()); //create a timestamp for today's date
        Timestamp one_month = Timestamp.from(Instant.now()); //create second timestamp for this date
        yesterday.setDate(yesterday.getDate() - 1);//modify the date to get yesterday's timestamp at the same hour
        one_month.setMonth(one_month.getMonth() - 1);//modify the date to get the one month's ago timestamp

        //we will create new users in our list
        for (int i = 0; i < 15; i++) {
            // generate random values for a user
            r_fname = fname[new Random().nextInt(fname.length)];
            r_lname = lname[new Random().nextInt(lname.length)];
            r_ages = ages[new Random().nextInt(ages.length)];
            r_uStatus = uStatus[new Random().nextInt(uStatus.length)];
            email = r_fname + r_lname + "@gmail.com";
            random_seconds = new Random().nextInt(3630000);
            Timestamp timestamp = Timestamp.from(Instant.now());
            timestamp.setSeconds(timestamp.getSeconds() - random_seconds);

            //create a new user with generated values
            User user = new User(r_fname, r_lname, r_ages, email, r_uStatus, timestamp);
            list.add(user);//add it to list
        }

        //call two verification functions
        Check_New(list, yesterday);
        Check_Inactive(list, one_month);

        //print results after verification
        for (User u : list) {
            System.out.println(u + "\n");
        }
    }

    public static void Check_New(ArrayList<User> list, Timestamp yesterday) {
        for (User u : list) {
            if (u.getStatus() == "New" && u.getTimestamp().before(yesterday)) {
                u.setStatus("Active");
            }
        }
    }

    public static void Check_Inactive(ArrayList<User> list, Timestamp one_month) {
        for (User u : list) {
            if (u.getStatus() == "Inactive" && u.getTimestamp().before(one_month)) {
                u.setStatus("Blocked");
            }
        }
    }

}
