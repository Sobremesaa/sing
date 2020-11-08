import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.EventListener;

public class UserLogin {
	public static void main(String args[]) {		//主方法
		Display display = new Display();
		display.setBounds(100,100,330,230);	//设置窗口初始位置
		display.setTitle("登录");		//设置窗口名
		display.setLocationRelativeTo(null);	//设置窗口位于屏幕中央
	}
}
		
class Display extends JFrame {
	JButton btnLogin, btnRegister, btnCancel;		//定义按钮登录、注册、取消
	JPanel pnlSouth, pnlNorth, pnlCenter, pnlCenter1, pnlCenter2;	//定义中间容器
	JLabel lbl1, lbl2, lbl3;				//定义标签
	JTextField tfName;				//定义单行文本输入框
	JPasswordField Pwd;				//定义密码输入框

	public Display() {
		setLayout(new java.awt.BorderLayout());	//设置布局
		init();
		setVisible(true);			//设置窗口可见
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	class ButtonListener implements ActionListener {	//定义ActionListener类的接口类
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnLogin)			//用户点击“登录”按钮
				check();
			else if(e.getSource() == btnRegister) {		//用户点击“注册”按钮
				UserRegister r = new UserRegister("注册");//新建名为“注册”窗口
				r.setBounds(200,400,250,230);
				r.setLocationRelativeTo(null);		//设置窗口位于屏幕中央
				r.setVisible(true);
			}
			else dispose();		//用户点击“取消”按钮
		}
	}

	public void init() {
		pnlNorth = new JPanel();
		lbl1 = new JLabel("欢迎来到点歌系统");
		Font f= new Font("宋体",Font.PLAIN,22);		//设置字体为“宋体”，风格为“普通”，字号“22”
		lbl1.setFont(f);
		lbl1.setForeground(Color.blue);			//定义字体颜色“蓝色”
		pnlNorth.add(lbl1);				//将标签添加到容器内
		this.add(pnlNorth,BorderLayout.NORTH);		//将容器添加到北部

		pnlCenter = new JPanel();			//新建面板
		pnlCenter1 = new JPanel();
		pnlCenter2 = new JPanel();
		pnlCenter.setLayout(new BorderLayout());		//设置布局
		lbl1 = new JLabel("账号：");			//新建标签，标签名为用户名
		tfName = new JTextField(10);
		pnlCenter1.add(lbl1);
		pnlCenter1.add(tfName);
		pnlCenter.add(pnlCenter1,BorderLayout.NORTH);	//将面板pnlCenter1添加到北部

		lbl3 = new JLabel("密码：");			//新建标签，标签名为密码
		Pwd = new JPasswordField(10);
		Pwd.setEchoChar('*');			//设置回显字符为”*“
		pnlCenter2.add(lbl3);
		pnlCenter2.add(Pwd);
		pnlCenter.add(pnlCenter2,BorderLayout.CENTER);

		this.add(pnlCenter,BorderLayout.CENTER);	//添加容器到中部

		pnlSouth = new JPanel();
		btnRegister = new JButton("注册");		//新建名为注册的按钮
		btnLogin = new JButton("登录");
		btnCancel = new JButton("取消");
		pnlSouth.add(btnRegister);
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnCancel);
		add(pnlSouth,BorderLayout.SOUTH);

		ButtonListener Listen = new ButtonListener();	//注册监视器
		btnLogin.addActionListener(Listen);		//对监视器进行授权
		btnRegister.addActionListener(Listen);
		btnCancel.addActionListener(Listen);
	}

	public int check() { 	//检查登录时账号密码是否输入正确
		return 1;
	}
}

class UserRegister extends JFrame {
	JLabel lbl,lbl1,lbl2,lbl3;
	JPanel pnlSouth,pnlNorth,pnlCenter,pnlCenter1,pnlCenter2,pnlCenter3;
	JTextField tfName;
	JPasswordField Pwd,cPwd;		//定义密码框
	JButton btnRegister,btnCancel;

	UserRegister(String title) {
		setTitle(title);
		init();
	}

	class ButtonListener implements ActionListener {		//定义ActionListener类的接口类	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnRegister) {	//用户点击“注册”按钮
				
			}
			else dispose();			//用户点击“取消”按钮
		}
	}

	void init() {
		pnlNorth = new JPanel();
		lbl = new JLabel("新用户注册");
		Font f= new Font("宋体",Font.PLAIN,18);		//设置字体为“宋体”，风格为“普通”，字号“18”
		lbl.setFont(f);
		lbl.setForeground(Color.blue);			//定义字体颜色“蓝色”
		pnlNorth.add(lbl);
		this.add(pnlNorth,BorderLayout.NORTH);		//将容器添加到北部

		pnlCenter = new JPanel();
		pnlCenter1 = new JPanel();
		pnlCenter2 = new JPanel();
		pnlCenter3 = new JPanel();
		pnlCenter.setLayout(new BorderLayout());
		lbl1 = new JLabel("账号：");
		tfName = new JTextField(10);
		pnlCenter1.add(lbl1);
		pnlCenter1.add(tfName);
		pnlCenter.add(pnlCenter1,BorderLayout.NORTH);

		lbl2 = new JLabel("密码：");
		Pwd = new JPasswordField(10);
		Pwd.setEchoChar('*');				//设置回显字符为”*“
		pnlCenter2.add(lbl2);
		pnlCenter2.add(Pwd);
		pnlCenter.add(pnlCenter2,BorderLayout.CENTER);
		
		lbl3 = new JLabel("确认密码：");
		cPwd = new JPasswordField(10);
		cPwd.setEchoChar('*');
		pnlCenter3.add(lbl3);
		pnlCenter3.add(cPwd);
		pnlCenter.add(pnlCenter3,BorderLayout.SOUTH);
		this.add(pnlCenter,BorderLayout.CENTER);

		pnlSouth = new JPanel();
		btnRegister = new JButton("注册");		//新建名为注册的按钮
		btnCancel = new JButton("取消");
		pnlSouth.add(btnRegister);
		pnlSouth.add(btnCancel);
		add(pnlSouth,BorderLayout.SOUTH);

		ButtonListener Listen = new ButtonListener();	//注册监视器
		btnRegister.addActionListener(Listen);		//对监视器进行授权
		btnCancel.addActionListener(Listen);
	}
}