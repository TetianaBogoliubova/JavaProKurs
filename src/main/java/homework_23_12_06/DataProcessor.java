package homework_23_12_06;

public class DataProcessor {

    //    public void processData(List<Integer> data) {
//        int sum = 0;
//        for (int num : data) {
//            sum += num;
//        }
//        System.out.println("Sum: " + sum);
//
//        double average = (double) sum / data.size();
//        System.out.println("Average: " + average);
//    }
//
//    public void processUserData(List<User> users) {
//        int totalAge = 0;
//        for (User user : users) {
//            //00.totalAge += user.getAge();
//        }
//        System.out.println("Total Age: " + totalAge);
//
//        double averageAge = (double) totalAge / users.size();
//        System.out.println("Average Age: " + averageAge);
//    }
//}
}

//          *** с исправлениями ***

//public class DataAndAge {

//    public double countAverageData(List<Integer> data) {
//        return data.stream()
//                .mapToDouble(value -> value)
//                .average()
//                .orElse(0.0);
//    }
//
//    public double countAverageAge(List<User> users) {

//        return users.stream()
//                .mapToDouble(User::getAge)
//                .average()
//                .orElse(0.0);
//    }
//}
