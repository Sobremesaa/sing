import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.EventListener;

public class UserLogin {
	public static void main(String args[]) {		//������
		Display display = new Display();
		display.setBounds(100,100,330,230);	//���ô��ڳ�ʼλ��
		display.setTitle("��¼");		//���ô�����
		display.setLocationRelativeTo(null);	//���ô���λ����Ļ����
	}
}
		
class Display extends JFrame {
	JButton btnLogin, btnRegister, btnCancel;		//���尴ť��¼��ע�ᡢȡ��
	JPanel pnlSouth, pnlNorth, pnlCenter, pnlCenter1, pnlCenter2;	//�����м�����
	JLabel lbl1, lbl2, lbl3;				//�����ǩ
	JTextField tfName;				//���嵥���ı������
	JPasswordField Pwd;				//�������������

	public Display() {
		setLayout(new java.awt.BorderLayout());	//���ò���
		init();
		setVisible(true);			//���ô��ڿɼ�
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	class ButtonListener implements ActionListener {	//����ActionListener��Ľӿ���
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnLogin)			//�û��������¼����ť
				check();
			else if(e.getSource() == btnRegister) {		//�û������ע�ᡱ��ť
				UserRegister r = new UserRegister("ע��");//�½���Ϊ��ע�ᡱ����
				r.setBounds(200,400,250,230);
				r.setLocationRelativeTo(null);		//���ô���λ����Ļ����
				r.setVisible(true);
			}
			else dispose();		//�û������ȡ������ť
		}
	}

	public void init() {
		pnlNorth = new JPanel();
		lbl1 = new JLabel("��ӭ�������ϵͳ");
		Font f= new Font("����",Font.PLAIN,22);		//��������Ϊ�����塱�����Ϊ����ͨ�����ֺš�22��
		lbl1.setFont(f);
		lbl1.setForeground(Color.blue);			//����������ɫ����ɫ��
		pnlNorth.add(lbl1);				//����ǩ��ӵ�������
		this.add(pnlNorth,BorderLayout.NORTH);		//��������ӵ�����

		pnlCenter = new JPanel();			//�½����
		pnlCenter1 = new JPanel();
		pnlCenter2 = new JPanel();
		pnlCenter.setLayout(new BorderLayout());		//���ò���
		lbl1 = new JLabel("�˺ţ�");			//�½���ǩ����ǩ��Ϊ�û���
		tfName = new JTextField(10);
		pnlCenter1.add(lbl1);
		pnlCenter1.add(tfName);
		pnlCenter.add(pnlCenter1,BorderLayout.NORTH);	//�����pnlCenter1��ӵ�����

		lbl3 = new JLabel("���룺");			//�½���ǩ����ǩ��Ϊ����
		Pwd = new JPasswordField(10);
		Pwd.setEchoChar('*');			//���û����ַ�Ϊ��*��
		pnlCenter2.add(lbl3);
		pnlCenter2.add(Pwd);
		pnlCenter.add(pnlCenter2,BorderLayout.CENTER);

		this.add(pnlCenter,BorderLayout.CENTER);	//����������в�

		pnlSouth = new JPanel();
		btnRegister = new JButton("ע��");		//�½���Ϊע��İ�ť
		btnLogin = new JButton("��¼");
		btnCancel = new JButton("ȡ��");
		pnlSouth.add(btnRegister);
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnCancel);
		add(pnlSouth,BorderLayout.SOUTH);

		ButtonListener Listen = new ButtonListener();	//ע�������
		btnLogin.addActionListener(Listen);		//�Լ�����������Ȩ
		btnRegister.addActionListener(Listen);
		btnCancel.addActionListener(Listen);
	}

	public int check() { 	//����¼ʱ�˺������Ƿ�������ȷ
		return 1;
	}
}

class UserRegister extends JFrame {
	JLabel lbl,lbl1,lbl2,lbl3;
	JPanel pnlSouth,pnlNorth,pnlCenter,pnlCenter1,pnlCenter2,pnlCenter3;
	JTextField tfName;
	JPasswordField Pwd,cPwd;		//���������
	JButton btnRegister,btnCancel;

	UserRegister(String title) {
		setTitle(title);
		init();
	}

	class ButtonListener implements ActionListener {		//����ActionListener��Ľӿ���	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnRegister) {	//�û������ע�ᡱ��ť
				
			}
			else dispose();			//�û������ȡ������ť
		}
	}

	void init() {
		pnlNorth = new JPanel();
		lbl = new JLabel("���û�ע��");
		Font f= new Font("����",Font.PLAIN,18);		//��������Ϊ�����塱�����Ϊ����ͨ�����ֺš�18��
		lbl.setFont(f);
		lbl.setForeground(Color.blue);			//����������ɫ����ɫ��
		pnlNorth.add(lbl);
		this.add(pnlNorth,BorderLayout.NORTH);		//��������ӵ�����

		pnlCenter = new JPanel();
		pnlCenter1 = new JPanel();
		pnlCenter2 = new JPanel();
		pnlCenter3 = new JPanel();
		pnlCenter.setLayout(new BorderLayout());
		lbl1 = new JLabel("�˺ţ�");
		tfName = new JTextField(10);
		pnlCenter1.add(lbl1);
		pnlCenter1.add(tfName);
		pnlCenter.add(pnlCenter1,BorderLayout.NORTH);

		lbl2 = new JLabel("���룺");
		Pwd = new JPasswordField(10);
		Pwd.setEchoChar('*');				//���û����ַ�Ϊ��*��
		pnlCenter2.add(lbl2);
		pnlCenter2.add(Pwd);
		pnlCenter.add(pnlCenter2,BorderLayout.CENTER);
		
		lbl3 = new JLabel("ȷ�����룺");
		cPwd = new JPasswordField(10);
		cPwd.setEchoChar('*');
		pnlCenter3.add(lbl3);
		pnlCenter3.add(cPwd);
		pnlCenter.add(pnlCenter3,BorderLayout.SOUTH);
		this.add(pnlCenter,BorderLayout.CENTER);

		pnlSouth = new JPanel();
		btnRegister = new JButton("ע��");		//�½���Ϊע��İ�ť
		btnCancel = new JButton("ȡ��");
		pnlSouth.add(btnRegister);
		pnlSouth.add(btnCancel);
		add(pnlSouth,BorderLayout.SOUTH);

		ButtonListener Listen = new ButtonListener();	//ע�������
		btnRegister.addActionListener(Listen);		//�Լ�����������Ȩ
		btnCancel.addActionListener(Listen);
	}
}