package op;
import java.awt.Dimension;
import java.util.Scanner;
import op.cripto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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
       teste da classe csar
       String p = " ";
       csar.transcriptase(p);
       */
       
       
      /* ###test area### 
       
       String p;
       String k;
       p = sc.nextLine();
       System.out.println(cripto.car(p));
       System.out.println(csar.transcriptase(cripto.car(p)));
       */
       
       
       
       
       //frame(2janela)
       
       JFrame janela2 = new JFrame();
       janela2.setBounds(100,100,400,400);
       janela2.setResizable(false);
       
       
       
       //label
        JLabel labelTitle = new JLabel("Criptograph Program 0.03v");
        labelTitle.setBounds(210, 20, 300, 30);
        janela.add(labelTitle);
        
        //label msg
        JLabel labelMsg = new JLabel("Digite a mensagem que deseja criptografar: ");
        
        //label descripto e key
        JLabel labelMSG = new JLabel("Digite a mensagem que deseja descriptografar: ");
        JLabel labelKey = new JLabel("Digite a chave de descriptografia: ");
        JLabel labelShift = new JLabel("Digite o shift de descriptografia: "); 
        
         JButton botao3 = new JButton("GO");
         JButton botao4 = new JButton("GO");
         
        //text area
        JTextArea Resp = new JTextArea();
        Resp.setLineWrap(true);
        
        //campo do usuario
        JTextField campoMsg = new JTextField();
        JTextField campoKey = new JTextField();    
        JTextField campoShift = new JTextField();
        campoKey.setBounds(100,160,300,30);
        campoMsg.setBounds(100,260,300,30);
        campoShift.setBounds(100,360,300,30);
        //add e criar botao
        
       JButton botao1 = new JButton("INICIAR");
        botao1.setBounds(190, 80, 200, 30);
        janela.add(botao1);
        botao1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
        JButton botao2 = new JButton("Criptografar");
        botao2.setBounds(310, 500, 200, 30);
        janela.add(botao2);
        botao2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.remove(labelShift);
                janela.remove(campoShift);
                janela.remove(labelMSG);
                janela.remove(campoMsg);
                janela.remove(campoKey);
                janela.remove(labelKey);
                janela.remove(botao4);
                labelMsg.setBounds(100, 100, 500, 100);
                campoMsg.setBounds(100, 160, 300, 30);
                janela.add(labelMsg);
                janela.add(campoMsg);
            
                
                
                botao3.setBounds(420, 158, 90, 30);
                janela.add(botao3);
                botao3.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String msg = campoMsg.getText();
                        try {
                            Resp.setText(cripto.car(msg));
                        } catch (IOException ex) {
                            System.getLogger(Op.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        }
                        Resp.setBounds(10, 10, 400, 400);
                        Resp.setLineWrap(true);
                        
                        campoMsg.setText("");
                  
                        janela.revalidate();
                        janela.repaint();
                       
                        
                 }
            
                });
                
                
                
                
                  
                janela.revalidate();
                janela.repaint();
            
            }
            
        });
        
         JButton botao = new JButton("Descriptografar");
        botao.setBounds(90, 500, 200, 30);
        janela.add(botao);
        botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  janela.remove(botao3);
                  janela.remove(campoMsg);
                  janela.remove(labelMsg);
                  labelMSG.setBounds(100, 100, 500, 100);
                  labelKey.setBounds(100, 200, 500, 100);
                  labelShift.setBounds(100, 300, 500, 100);
                  campoKey.setBounds(100, 260, 300, 30);
                  campoMsg.setBounds(100, 160, 300, 30);
                  campoShift.setBounds(100,360,300,30);
                  janela.add(labelShift);
                  janela.add(campoShift);
                  janela.add(labelMSG);
                  janela.add(campoMsg);
                  janela.add(campoKey);
                  janela.add(labelKey);
                  
                  botao4.setBounds(420, 158, 90, 30);
                janela.add(botao4);
                botao4.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String msg = campoMsg.getText();
                        String key = campoKey.getText();
                        String shift = campoShift.getText();
                        int shift1 = Integer.parseInt(shift);
                        
                        Resp.setText(cripto.carInverse(msg, key, shift1));
                        Resp.setBounds(10, 10, 400, 400);
                        Resp.setLineWrap(true);
                        janela2.add(Resp);
                        janela2.setVisible(true);
                        
                        campoMsg.setText("");
                        
                        janela.revalidate();
                        janela.repaint();
                        janela2.revalidate();
                        janela2.repaint();
                        
            
                 }
            
                });
                  
                  
                  
                  janela.revalidate();
                  janela.repaint();
            
            }
            
        });
        
        
        
        
                
                janela.revalidate();
                janela.repaint();
                
                
                
            }
            
        });
        
      
       
       
       
       
       
       
       
       
       
       
       
       
       //janela
        janela.setLayout(null);
        janela.setBounds(350, 55, 600, 600);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
   
}
