package com.murad.java8practise.builderPatternOrCascadePattern;

import java.util.function.Consumer;

class MailBuilder {
    public static void print(String line) {
        System.out.println(line);
    }

    public MailBuilder from(String addr) {
        print(addr);
        return this;
    }

    public MailBuilder to(String addr) {
        print(addr);
        return this;
    }

    public MailBuilder subject(String sub) {
        print(sub);
        return this;
    }

    public MailBuilder body(String body) {
        print(body);
        return this;
    }


    public static void send(Consumer<MailBuilder> consumer) {
        MailBuilder mailBuilder = new MailBuilder();
        consumer.accept(mailBuilder);
        print("sending............");
    }
}

public class BuilderExample {
    public static void main(String[] args) {



        MailBuilder.send(mailBuilder ->
                mailBuilder
                        .from("mmuradul@gmil.com")
                        .to("mmurad@gmil.com")
                        .subject("subject")
                        .body("here you go.........."));

        Consumer<MailBuilder> consumer= mailBuilder -> mailBuilder.subject("another subject").body("another body");
        MailBuilder.send(consumer);

//        MailBuilder.send(mailBuilder -> new MailBuilder().body("another body"));

    }
}
