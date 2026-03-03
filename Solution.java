import java.util.Scanner;
import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen Sağlık Profili bilgilerinizi girin:");

        System.out.print("Adınız: ");
        String firstName = input.nextLine();

        System.out.print("Soyadınız: ");
        String lastName = input.nextLine();

        System.out.print("Cinsiyetiniz (Erkek/Kadın): ");
        String gender = input.nextLine();

        System.out.print("Doğum Gününüz : ");
        int birthDay = input.nextInt();

        System.out.print("Doğum Ayınız : ");
        int birthMonth = input.nextInt();

        System.out.print("Doğum Yılınız : ");
        int birthYear = input.nextInt();

        System.out.print("Boyunuz : ");
        double heightCm = input.nextDouble();

        System.out.print("Kilonuz : ");
        double weightKg = input.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender,
                birthDay, birthMonth, birthYear,
                heightCm, weightKg);

        System.out.println("\n--- OLUŞTURULAN SAĞLIK PROFİLİ ---");
        System.out.println("Ad Soyad: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Cinsiyet: " + profile.getGender());
        System.out.println("Doğum Tarihi: " + profile.getBirthDay() + "/" +
                profile.getBirthMonth() + "/" + profile.getBirthYear());
        System.out.println("Boy: " + profile.getHeightCm() + " cm");
        System.out.println("Kilo: " + profile.getWeightKg() + " kg");
        System.out.println("-----------------------------------");
        System.out.println("Hesaplanan Yaş: " + profile.getAge());

        System.out.printf("Vücut Kitle İndeksi (BMI): %.2f\n", profile.getBMI());
        System.out.println("BMI Durumu: " + profile.getBMIStatus() + " ");

        input.close();
    }
}


class HealthProfile {

    private String firstName;
    private String lastName;
    private String gender;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private double heightCm; // Boy (cm cinsinden)
    private double weightKg; // Kilo (kg cinsinden)


    public HealthProfile(String firstName, String lastName, String gender,
                         int birthDay, int birthMonth, int birthYear,
                         double heightCm, double weightKg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setHeightCm(double heightCm) {
        this.heightCm = heightCm;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getWeightKg() {
        return weightKg;
    }


    public int getAge() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - this.birthYear;
    }


    public double getBMI() {
        double heightInMeters = this.heightCm / 100.0;
        return this.weightKg / (heightInMeters * heightInMeters);
    }


    public String getBMIStatus() {
        double bmi = getBMI(); // BMI hesapla

        if (bmi < 18.5) {
            return "Zayıf (Underweight)";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Fazla Kilolu (Overweight)";
        } else { // 30 ve üzeri
            return "Obez (Obese)";
        }
    }
}
