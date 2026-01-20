package op;
import java.awt.Dimension;
import java.util.Scanner;
import op.cripto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author fipeA-dev
 */
public class Op {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       JFrame janela = new JFrame();
       
       /*
       ###test area### 
       String p;
       String k;
       p = sc.nextLine();
       System.out.println(cripto.car(p));
        #############
       */
       
       
       
       //label
        JLabel labelTitle = new JLabel("Criptograph Program 0.01v");
        labelTitle.setBounds(210, 20, 300, 30);
        janela.add(labelTitle);
        
        //label msg
        JLabel labelMsg = new JLabel("Digite a mensagem que deseja criptografar: ");
        
        //label descripto e key
        JLabel labelMSG = new JLabel("Digite a mensagem que deseja descriptografar: ");
        JLabel labelKey = new JLabel("Digite a chave de descriptografia: ");
        
        //label resp
         JLabel labelR0 = new JLabel(" ");
         JLabel labelR1 = new JLabel(" ");
         JLabel labelR2 = new JLabel("A mensagem é: ");
         JLabel labelR3 = new JLabel("A mensagem criptografada e: ");

        //campo do usuario
        JTextField campoMsg = new JTextField();
        JTextField campoKey = new JTextField();    
         campoKey.setBounds(100,160,300,30);
         campoMsg.setBounds(100,260,300,30);
        //add e criar botao
        JButton botao = new JButton("Descriptografar");
        botao.setBounds(90, 500, 200, 30);
        janela.add(botao);
        botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  janela.remove(campoMsg);
                  janela.remove(labelR2);
                  janela.remove(labelR1);
                  janela.remove(campoKey);
                  janela.remove(labelMSG);
                  janela.remove(labelKey);
                  janela.remove(labelMsg);
                  labelKey.setBounds(100, 130, 300, 30);
                  janela.add(labelKey);
                  labelMSG.setBounds(100, 230, 300, 30);
                  janela.add(labelMSG);
                  campoKey.setBounds(100,160,300,30);
                  campoMsg.setBounds(100,260,300,30);
                  janela.add(campoMsg);
                  janela.add(campoKey);
                  
                  String msg = campoMsg.getText();
                  String key = campoKey.getText();
                  labelR1.setText(cripto.carInverse(msg, key));
                  labelR1.setBounds(100, 330, 300, 30);
                  janela.add(labelR1);
                  labelR2.setBounds(100, 300, 300, 30);
                  janela.add(labelR2);
                  
                  
                  
                  
                  
                  janela.revalidate();
                  janela.repaint();
            
            }
            
        });
       JButton botao1 = new JButton("Criptografar");
        botao1.setBounds(310, 500, 200, 30);
        janela.add(botao1);
        botao1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.remove(campoMsg);
                janela.remove(labelR1);
                janela.remove(labelR2);
                janela.remove(labelMSG);
                janela.remove(labelKey);
                janela.remove(labelMsg);
                labelMsg.setBounds(100, 130, 300, 30);
                janela.add(labelMsg);
                campoMsg.setBounds(100,160,300,30);
                janela.add(campoMsg);
                janela.remove(campoKey);
                
                
                String msg = campoMsg.getText();
                labelR0.setText(cripto.car(msg));
                labelR3.setBounds(100, 190, 300, 30);
                janela.add(labelR3);
                labelR0.setBounds(100, 210, 300, 30);
                labelR0.setPreferredSize(new Dimension(300, 500));
                janela.add(labelR0);
                
                
                janela.revalidate();
                janela.repaint();
                
                
                
            }
            
        });
        
      
       
       
       
       
       
       
       
       
       
       
       
       
       //janela
        janela.setLayout(null);
        janela.setBounds(350, 55, 600, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
   
}
