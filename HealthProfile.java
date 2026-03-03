import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Ad: ");
        String firstName = input.nextLine();

        System.out.print("Soyad: ");
        String lastName = input.nextLine();

        System.out.print("Cinsiyet: ");
        String gender = input.nextLine();

        System.out.print("Doğum günü (1-31): ");
        int day = input.nextInt();

        System.out.print("Doğum ayı (1-12): ");
        int month = input.nextInt();

        System.out.print("Doğum yılı: ");
        int year = input.nextInt();

        System.out.print("Boy (cm): ");
        double height = input.nextDouble();

        System.out.print("Kilo (kg): ");
        double weight = input.nextDouble();

        HealthProfile hp = new HealthProfile(firstName, lastName, gender,
                day, month, year,
                height, weight);

        System.out.println("\n--- Kişi Bilgileri ---");
        System.out.println("Ad: " + hp.getFirstName());
        System.out.println("Soyad: " + hp.getLastName());
        System.out.println("Cinsiyet: " + hp.getGender());
        System.out.println("Doğum Tarihi: " +
                hp.getBirthDay() + "/" + hp.getBirthMonth() + "/" + hp.getBirthYear());
        System.out.println("Boy (cm): " + hp.getHeight());
        System.out.println("Kilo (kg): " + hp.getWeight());

        System.out.println("\n--- Hesaplamalar ---");
        System.out.println("Yaş: " + hp.calculateAge());
        System.out.printf("BMI: %.2f\n", hp.calculateBMI());
        System.out.println("BMI Kategorisi: " + hp.bmiCategory());
    }
}

class HealthProfile {

    private String firstName;
    private String lastName;
    private String gender;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private double height;
    private double weight;

    public HealthProfile(String firstName, String lastName, String gender,
                         int birthDay, int birthMonth, int birthYear,
                         double height, double weight) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.height = height;
        this.weight = weight;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public int getBirthDay() { return birthDay; }
    public int getBirthMonth() { return birthMonth; }
    public int getBirthYear() { return birthYear; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public int calculateAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        return Period.between(birthDate, today).getYears();
    }

    public double calculateBMI() {
        double h = height / 100.0;
        return weight / (h * h);
    }

    public String bmiCategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) return "Zayıf";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Fazla Kilolu";
        else return "Obez";
    }
}
