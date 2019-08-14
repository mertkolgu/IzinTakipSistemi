/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author Mert
 * 1421012072 Mert Kolğu
 * 1421012034 Emre Küçük
 */
public class ProgressBarYonetici {

    private JProgressBar ilerlemeCubugu;
    private JTextArea gunluk;
    private Gorev gorev;
    private static int ILERLEME_MIKTARI = 20;
    private static int BEKLEME_MIKTARI = 650;

    public ProgressBarYonetici(JProgressBar ilerlemeCubugu, JTextArea gunluk) {
        this.ilerlemeCubugu = ilerlemeCubugu;
        this.gunluk = gunluk;
        gorev = new Gorev();
    }

    class Gorev extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            int ilerleme = 0;
            setProgress(0);
            while (ilerleme < 100) {
                try {
                    Thread.sleep(BEKLEME_MIKTARI);
                } catch (InterruptedException ignore) {
                }
                ilerleme += ILERLEME_MIKTARI;
                setProgress(Math.min(ilerleme, 100));
            }
            return null;
        }

        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            gunluk.append("Veritabanı Bağlantısı Başarılı!\n");
        }
    }

    private class GorevDinleyici implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("progress")) {
                int ilerleme = (Integer) evt.getNewValue();
                ilerlemeCubugu.setValue(ilerleme);
                gunluk.append(String.format("Bağlantı Durumu: %d%%\n", gorev.getProgress()));
            }
        }
    }

    public void baslat() {
        gorev.addPropertyChangeListener(new GorevDinleyici());
        gorev.execute();
    }
}
