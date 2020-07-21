public class FamilyAccountTest {
    public static void main(String[] args){
        boolean isFalse = true;
        // 初始金额
        int balance = 10000;

        // 记录用户的收支情况
        String details = "";

        while(isFalse){
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println("\t\t\t\t1\t收支明细");
            System.out.println("\t\t\t\t2\t登记收入");
            System.out.println("\t\t\t\t3\t登记支出");
            System.out.println("\t\t\t\t4\t退\t出\n");
            System.out.print("\t\t\t\t请选择(1-4)：");

            // 获取用户的选择：1-4
            char selection = Utility.readMenuSelection();

            switch(selection){
                // 收入明细选项
                case '1':
                    //System.out.println("\t1\t收支明细");

                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println("收支\t\t账户金额\t\t收支金额\t\t说    明");
                    System.out.println(details);
                    System.out.println("---------------------登记完成---------------------\n");

                    break;

                // 登记收入选项
                case '2':
                    //System.out.println("\t2\t登记收入");
                    System.out.print("本次收入金额：");
                    int addMoney = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String addInfo = Utility.readString();

                    // 处理balance
                    balance += addMoney;

                    // 处理details
                    details += ("收入\t\t" + balance + "\t\t" + "+"+addMoney + "\t\t" + addInfo + "\n");

                    break;


                // 登记支出选项
                case '3':
                    //System.out.println("\t3\t登记支出");
                    System.out.print("本次支出金额：");
                    int minusMoney = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String minusInfo = Utility.readString();

                    // 处理balance
                    balance -= minusMoney;

                    // 处理details
                    details += ("支出\t\t" + balance + "\t\t" + "-"+minusMoney + "\t\t" + minusInfo + "\n");

                    break;

                // 退出选项
                case '4':
                    //System.out.println("\t4\t退\t出");
                    System.out.print("确认是否退出（Y/N）：");
                    char isExit =Utility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFalse = false;
                    }

                    break;
            }

        }
    }
}
