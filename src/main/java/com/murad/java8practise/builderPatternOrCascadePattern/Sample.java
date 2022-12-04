package com.murad.java8practise.builderPatternOrCascadePattern;

class Mailer {
    public static void print(String line) {
        System.out.println(line);
    }

    public void from(String addr) {
        print(addr);
    }
    public void to(String addr) {
        print(addr);
    }
    public void subject(String sub) {
        print(sub);
    }
    public void body(String body) {
        print(body);
    }
    public void send() {
        print("sending............");
    }
}
public class Sample{
    public static void main(String[] args) {

        Mailer mailer=new Mailer();
        mailer.from("mmuradul@gmil.com");
        mailer.to("mmurad@gmil.com");
        mailer.subject("subject");
        mailer.body("here you go..........");
        mailer.send();
    }
}
