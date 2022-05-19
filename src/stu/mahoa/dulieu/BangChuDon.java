package stu.mahoa.dulieu;

import java.util.Random;

public class BangChuDon {

    //khai báo thuộc tính
    private String text;
    private String textCanGiaiMa;

    public String getTextCanGiaiMa() {
        return textCanGiaiMa;
    }

    public void setTextCanGiaiMa(String textCanGiaiMa) {
        this.textCanGiaiMa = textCanGiaiMa;
    }
    private int[] bangChu;
    private int[] key;

    //khởi tạo các phương thức
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getBangChu() {
        return bangChu;
    }

    public void setBangChu(int[] bangChu) {
        this.bangChu = bangChu;
    }

    public int[] getKey() {
        return key;
    }

    public void setKey(int[] key) {
        this.key = key;
    }

    public BangChuDon() {
        this.text = "";
        this.textCanGiaiMa = "";
        bangChu = new int[26];
        key = new int[26];
    }

    //phương thức khởi tạo dữ liệu từ 65-90
    private void taoDulieu() {
        for (int i = 0; i < 26; i++) {
            this.bangChu[i] = i + 65;
        }
    }

    public void chuyendoi() {
        for (int i = 0; i < 26; i++) {
            this.key[i] = -1;
        }
    }

    //phương thức tạo random các giá trị gồm 26 số không trùng nhau
    public void taoKey() {
        this.chuyendoi();
        Random rb = new Random();//khai báo phương thức random trong thư viện của java
        int spt = 0;
        while (spt != 26) {
            int k = rb.nextInt(26);//khởi tạo 1 giá trị ngẫu nhiên từ 0-26
            int dem = 0;
            for (int j : this.key) {//duyệt lần lượt từng phần tử 
                if (j == k) {//nếu j trùng với giá trị k được tạo ra 
                    dem++;//đém tăng lên 1
                }
            }
            if (dem == 0) {//nếu đếm = 0 
                this.key[spt] = k;//gán k vào key 
                spt++;//spt tăng lên 1
            }
        }
    }

    //phương thức biến các số đã khởi tạo thành bảng chữ cái từ A-Z
    public String abc() {
        String text = "";//khai báo chuỗi rỗng
        this.taoDulieu();
        for (int i : this.bangChu) {//duyệt lần lượt các pt
            text = text + (char) i;//ghép các chuỗi lại
        }
        return text;
    }

    //phương thức biến 26 số được random ngẫu nhiên không trùng nhau thành bảng chữ cái 
    public String key1() {
        String text = "";
        this.taoKey();
        for (int i : this.key) {
            text = text + (char) (i + 65);//chuyển đổi các giá trị số thành ký tự
        }
        return text;
    }

    //phương thức mã hóa Bảng chữ đơn
    public String maHoa() {
        String textMaHoa = "";//khai báo chuỗi rỗng
        this.text.toUpperCase();//chuyển đổi các chữ thường thành hoa
        char[] cd = this.text.toCharArray();//chuyển đổi chuỗi nhập vào thành mảng
        for (int i = 0; i < cd.length; i++) {//duyệt lần lượt các phần tử trong chuỗi vừa nhập vào
            for (int j = 0; j < 26; j++) {//duyệt lần lượt các phần tử trong  key tư a-z
                if (cd[i] == bangChu[j]) {//so sánh giá trị của chuỗi nhập vào và key từ a-z
                    int k = this.key[j] + 65;//lấy giá trị đc tạo ngẫu nhiên cộng 65 
                    textMaHoa = textMaHoa + (char) k;//chuyển đổi số thành ký tự
                }
            }
        }
        return textMaHoa;
    }

    //phương thức giải mã Bảng chữ đơn
    public String giaiMa() {
        String textGiaiMa = "";//khai báo chuỗi rỗng
        this.textCanGiaiMa.toUpperCase();//chuyển đổi các chữ thường thành hoa
        char[] cd = this.textCanGiaiMa.toCharArray();//chuyển đổi chuỗi nhập vào thành mảng
        for (int i = 0; i < cd.length; i++) {//duyệt lần lượt các phần tử trong chuỗi vừa nhập vào
            for (int j = 0; j < 26; j++) {//duyệt lần lượt các phần tử trong  key tư a-z
                if (cd[i] == this.key[j] + 65) {//so sánh giá trị của chuổi nhập vào với key đc tạo ngẫu nhiên
                    textGiaiMa = textGiaiMa + (char) this.bangChu[i];//ghép và chuyển đổi các giá trị của bảng chữ cái
                }
            }
        }
        return textGiaiMa;
    }
}
