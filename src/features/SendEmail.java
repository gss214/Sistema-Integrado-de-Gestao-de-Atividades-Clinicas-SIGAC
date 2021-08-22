package features;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import pessoas.Medico;
import pessoas.Paciente;


public class SendEmail
{
    public static boolean verifyEmail (String email){
        Properties props = new Properties();

        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
          new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication()
               {
                     return new PasswordAuthentication("",
                     "");
               }
          });

        // para debugar 
        //session.setDebug(true);
        
        try {

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("sigaac.system@gmail.com"));
          //Remetente
          Address[] toUser = InternetAddress.parse(email);

          message.setRecipients(Message.RecipientType.TO, toUser);
          String msg = "Bem vindo ao SIGAC";
          message.setSubject("Bem vindo ao SIGAC");//Assunto
          message.setText(msg);
          /**Método para enviar a mensagem criada*/
          Transport.send(message);
          return true;
          
         } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Email invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static void sendEmail(String receita, Paciente paciente, Medico medico){
        
        
        Properties props = new Properties();

        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
          new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication()
               {
                     return new PasswordAuthentication("sigaac.system@gmail.com",
                     "vtkIky%Javb1");
               }
          });

        // para debugar 
        //session.setDebug(true);

        try {

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("sigaac.system@gmail.com"));
          //Remetente
          Address[] toUser = InternetAddress.parse(paciente.getEmail());

          message.setRecipients(Message.RecipientType.TO, toUser);
          String msg = "Dados do paciente:\n\nNome: " + paciente.getNome() + "\nConvênio: " + paciente.getConvenio() +
                  "\nReceita: " + receita + "\nReceitado por\n" + medico.getNome() + "\nCRM: " + medico.getInscricaoCRM();
          message.setSubject("Receita Médica - SIGAC");//Assunto
          message.setText(msg);
          /**Método para enviar a mensagem criada*/
          Transport.send(message);
          JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);

         } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Falha ao enviar o email!", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
}