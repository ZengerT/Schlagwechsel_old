import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;


public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        final Schlagwechsel window = new Schlagwechsel();
        final Turnier tun = new Turnier();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window.getTfMann().setDocument(new IntegerDocument(3));
                    window.getTfRunden().setDocument(new IntegerDocument(3));
                    window.getTfTurnier().setDocument(new StringDocument(40));
                    window.getFrame().setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
        window.getBtnGenerate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                Paar[] all = new Paar[0];
                tun.setName(window.getTfTurnier().getText());
                tun.setRunden(Integer.parseInt(window.getTfRunden().getText()));
                tun.setSpieler(Integer.parseInt(window.getTfMann().getText()));
                all = new Paar[tun.getRunden()];
                int[] team = new int[tun.getSpieler()];

                int a;
                for(a = 0; a < tun.getSpieler(); ++a) {
                    team[a] = a + 1;
                }

                for(a = 0; a < tun.getRunden(); ++a) {
                    Main.add(all, tun.calc(team, a), count);
                    ++count;
                }

                Main.pdf(team, all, tun);

                for(a = 0; a < tun.getRunden(); ++a) {
                    for(int i = 0; i < team.length / 2; ++i) {
                        System.out.println(all[a].getA()[i] + "   " + all[a].getB()[i]);
                    }

                    System.out.println();
                }

            }
        });
    }

    public static void add(Paar[] all, Paar paar, int count) {
        all[count] = paar;
    }

    public static void pdf(int[] team, Paar[] all, Turnier tun) {
        PDDocument document = new PDDocument();

        try {
            PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
            document.addPage(page);
            PDDocumentInformation pdd = document.getDocumentInformation();
            pdd.setAuthor("Schlagwechsel");
            pdd.setTitle("Spielplan");
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDFont font = PDType0Font.load(document, new FileInputStream("OpenSans-Regular.ttf"));
            contentStream.setFont(font, 28.0F);
            contentStream.setLeading(24.0D);
            int tx = 50;
            int ty = 500;
            contentStream.beginText();
            contentStream.newLineAtOffset((float)tx, (float)ty);
            String title = tun.getName();
            contentStream.showText(title);
            contentStream.newLine();
            contentStream.endText();
            ty = ty - 50;

            for(int a = 0; a < tun.getRunden(); ++a) {
                contentStream.beginText();
                contentStream.newLineAtOffset((float)tx, (float)ty);
                contentStream.setFont(font, 24.0F);
                String h = "Runde " + (a + 1);
                contentStream.showText(h);
                contentStream.newLine();

                for(int i = 0; i < team.length / 2; ++i) {
                    contentStream.setFont(font, 16.0F);
                    String s;
                    if (all[a].getA()[i] >= 10) {
                        s = String.valueOf(all[a].getA()[i]) + "        " + all[a].getB()[i];
                    } else {
                        s = String.valueOf(all[a].getA()[i]) + "          " + all[a].getB()[i];
                    }

                    contentStream.showText(s);
                    contentStream.newLine();
                }

                contentStream.newLine();
                contentStream.endText();
                tx += 150;
                contentStream.moveTo((float)tx, (float)ty);
            }

            contentStream.close();
            document.save("Turnier.pdf");
            document.close();
        } catch (IOException var15) {
            var15.printStackTrace();
        }

    }
}
