package ru.trandefil.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailBuilder {

    private String emailFromByDefault = "noname@yandex.ru";

    public IEmailRouteBuilder addSubject(String subject) {
        return new EmailRouteBuilder(subject);
    }

    private class EmailRouteBuilder implements IEmailRouteBuilder {
        private String subject;

        public EmailRouteBuilder(String subject) {
            this.subject = subject;
        }

        public IEmailToBuilder addEmailFrom(String emailFrom) {
            return new EmailToBuilder(subject, emailFrom);
        }

        public IEmailToBuilder addEmailTo(String... emailTo) {
            return new EmailToBuilder(subject, Arrays.asList(emailTo));
        }

        public IEmailToBuilder addEmailTo(String emailTo) {
            return new EmailToBuilder(subject, Arrays.asList(emailTo));
        }
    }

    private class EmailFromBuilder implements IEmailFromBuilder {
        private String subject;
        private String emailFrom;

        public EmailFromBuilder(String subject, String emailFrom) {
            this.subject = subject;
            this.emailFrom = emailFrom;
        }

        public IEmailToBuilder addEmailTo(String... emailTo) {
            return new EmailToBuilder(subject, emailFrom, Arrays.asList(emailTo));
        }

        public IEmailToBuilder addEmailTo(String emailTo) {
            return new EmailToBuilder(subject, emailFrom, Arrays.asList(emailTo));
        }
    }

    private class EmailToBuilder implements IEmailToBuilder {
        private String subject;
        private String emailFrom;
        private List<String> emailTo;

        public EmailToBuilder(String subject, String emailFrom) {
            this.subject = subject;
            this.emailFrom = emailFrom;
            emailTo = new ArrayList<String>();
        }

        public EmailToBuilder(String subject, String emailFrom, List<String> emailTo) {
            this.subject = subject;
            this.emailFrom = emailFrom;
            this.emailTo = new ArrayList<String>(emailTo);
        }

        public EmailToBuilder(String subject, List<String> emailTo) {
            this.subject = subject;
            this.emailTo = new ArrayList<String>(emailTo);
            this.emailFrom = emailFromByDefault;
        }

        public IEmailToBuilder addEmailTo(String... emailTo) {
            this.emailTo.addAll(Arrays.asList(emailTo));
            return this;
        }

        public IEmailToBuilder addEmailTo(String emailTo) {
            this.emailTo.add(emailTo);
            return this;
        }

        public IEmailCopyToBuilder addEmailCopyTo(String... emailCopyTo) {
            return new EmailCopyToBuilder(subject, emailFrom, emailTo, Arrays.asList(emailCopyTo));
        }

        public IEmailCopyToBuilder addEmailCopyTo(String emailCopyTo) {
            return new EmailCopyToBuilder(subject, emailFrom, emailTo, Arrays.asList(emailCopyTo));
        }
    }

    private class EmailCopyToBuilder implements IEmailCopyToBuilder {
        private String subject;
        private String emailFrom;
        private List<String> emailTo;
        private List<String> emailCopyTo;

        public EmailCopyToBuilder(String subject, String emailFrom, List<String> emailTo, List<String> emailCopyTo) {
            this.subject = subject;
            this.emailFrom = emailFrom;
            this.emailTo = emailTo;
            this.emailCopyTo = new ArrayList<String>(emailCopyTo);
        }

        public IEmailCopyToBuilder addEmailCopyTo(String... emailCopyTo) {
            this.emailCopyTo.addAll(Arrays.asList(emailCopyTo));
            return this;
        }

        public IEmailCopyToBuilder addEmailCopyTo(String emailCopyTo) {
            this.emailCopyTo.add(emailCopyTo);
            return this;
        }

        public IEmailContentBuilder addContent(String body, String signature) {
            Content content = new Content(body, signature);
            return new EmailContentBuilder(subject, emailFrom, emailTo, emailCopyTo, content);
        }
    }

    private class EmailContentBuilder implements IEmailContentBuilder {
        private String subject;
        private String emailFrom;
        private List<String> emailTo;
        private List<String> emailCopyTo;
        private Content content;

        public EmailContentBuilder(String subject, String emailFrom, List<String> emailTo, List<String> emailCopyTo, Content content) {
            this.subject = subject;
            this.emailFrom = emailFrom;
            this.emailTo = emailTo;
            this.emailCopyTo = emailCopyTo;
            this.content = content;
        }

        public String build() {
            return "Email{" +
                    "subject='" + subject + '\'' +
                    ", emailFrom='" + emailFrom + '\'' +
                    ", emailTo=" + emailTo +
                    ", emailCopyTo=" + emailCopyTo +
                    ", content=" + content +
                    '}';
        }
    }


    public interface IEmailRouteBuilder {
        IEmailToBuilder addEmailFrom(String emailFrom);

        IEmailToBuilder addEmailTo(String... emailTo);

        IEmailToBuilder addEmailTo(String emailTo);
    }

    public interface IEmailFromBuilder {
        IEmailToBuilder addEmailTo(String... emailTo);
        IEmailToBuilder addEmailTo(String emailTo);
    }

    public interface IEmailToBuilder {
        IEmailToBuilder addEmailTo(String... emailTo);

        IEmailToBuilder addEmailTo(String emailTo);

        IEmailCopyToBuilder addEmailCopyTo(String... emailCopyTo);

        IEmailCopyToBuilder addEmailCopyTo(String emailCopyTo);
    }

    public interface IEmailCopyToBuilder {
        IEmailCopyToBuilder addEmailCopyTo(String... emailCopyTo);

        IEmailCopyToBuilder addEmailCopyTo(String emailCopyTo);

        IEmailContentBuilder addContent(String body, String signature);
    }

    public interface IEmailContentBuilder {
        String build();
    }

}
