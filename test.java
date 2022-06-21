public class homework1 extends JFrame {
    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("计算下一天");
        // 设置宽和高
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        placeComponents(panel);
        // 设置界面可见
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel A = new JLabel("年");
        A.setBounds(10, 20, 80, 25);
        panel.add(A);
        JTextField a = new JTextField(20);
        a.setBounds(100, 20, 165, 25);
        panel.add(a);
        JLabel B = new JLabel("月");
        B.setBounds(10, 50, 80, 25);
        panel.add(B);
        JTextField b = new JTextField(20);
        b.setBounds(100, 50, 165, 25);
        panel.add(b);
        JLabel C = new JLabel("日");
        C.setBounds(10, 80, 80, 25);
        panel.add(C);
        JTextField c = new JTextField(20);
        c.setBounds(100, 80, 165, 25);
        panel.add(c);
        JLabel D = new JLabel("下一天");
        D.setBounds(10, 110, 80, 25);
        panel.add(D);
        JTextField d = new JTextField(20);
        d.setBounds(100, 110, 165, 25);
        panel.add(d);
        JButton pan = new JButton("计算下一天");
        pan.setBounds(50, 140, 150, 25);
        panel.add(pan);
        pan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1, s2, s3;
                s1 = a.getText().toString();
                s2 = b.getText().toString();
                s3 = c.getText().toString();
                Boolean ok = true;
                for (int i = 0; i < s1.length(); ++i) {
                    if (s1.charAt(i) < '0' || s1.charAt(i) > '9')
                        ok = false;
                }
                for (int i = 0; i < s2.length(); ++i) {
                    if (s2.charAt(i) < '0' || s2.charAt(i) > '9')
                        ok = false;
                }
                for (int i = 0; i < s3.length(); ++i) {
                    if (s3.charAt(i) < '0' || s3.charAt(i) > '9')
                        ok = false;
                }
                if (ok == true) {
                    int aa = Integer.parseInt(s1);
                    int bb = Integer.parseInt(s2);
                    int cc = Integer.parseInt(s3);
                    if (aa > 2050) {
                        d.setText("参数输入超限");
                    } else if (bb >= 13 || cc >= 32) {
                        d.setText("不可能");
                    } else if (bb == 2 && cc == 29) {
                        if ((aa % 400 == 0) || (aa % 100 != 0 && aa % 4 == 0))
                            d.setText(aa + "/3/1");
                        else
                            d.setText("不可能");
                    } else if (bb == 2 && cc == 30) {
                        d.setText("不可能");
                    } else {
                        Calendar c = Calendar.getInstance();
                        c.set(aa, bb, cc);
                        Date date = c.getTime();
                        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD");
                        int year = c.get(Calendar.YEAR);
                        int month = c.get(Calendar.MONTH);
                        int day = c.get(Calendar.DATE);
                        c.set(year, month, day + 1);
                        year = c.get(Calendar.YEAR);
                        month = c.get(Calendar.MONTH);
                        day = c.get(Calendar.DATE);
                        d.setText(year + "/" + month + "/" + day);
                    }
                } else {
                    d.setText("参数输入非法");
                }
            }
        });
        JButton scan = new JButton("重新输入");
        scan.setBounds(210, 140, 150, 25);
        panel.add(scan);
        scan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setText("");
                b.setText("");
                c.setText("");
            }
        });
    }
}
