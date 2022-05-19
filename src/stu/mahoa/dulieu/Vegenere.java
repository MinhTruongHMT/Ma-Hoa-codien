/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stu.mahoa.dulieu;

/**
 *
 * @author truong
 */
public class Vegenere {

    //khai báo các thuộc tính
    private String textmahoa;
    private String key;

    //khởi tạo các phương thức
    public Vegenere() {
    }

    public Vegenere(String textmahoa, String key) {
        this.textmahoa = textmahoa;
        this.key = key;
    }

    public String getTextmahoa() {
        return textmahoa;
    }

    public void setTextmahoa(String textmahoa) {
        this.textmahoa = textmahoa;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    //phương thức tạo key lạp lại theo số lượng ký tự nhập vào
    public char[] taokey() {
        String ttt = this.key.toUpperCase();//chuyển đổi keyword từ chữ thừng sang chữ in
        char a[] = ttt.toCharArray();//chuyển đổi key thành mảng
        char b[] = this.textmahoa.toCharArray();//chuyển đổi chuỗi nhập vào thành mảng
        int vt = 0;//khai báo biến vị trí của keyword 
        int vtt = 0;//khai bòa biến vị trí của key 
        char c[] = new char[textmahoa.length()];//khởi tạo 1 mảng có độ dài bằng số ký tự nhập vào để chứa key sau khi lặp lại
        for (int i = 0; i < b.length; i++) {//duyệt lần lượt các phần tử trong chuổi vừa nhập vào
            if ((int) b[i] != 32) {//kiểm tra nếu chuỗi nhập vào có khoảng cách hay ko, nếu ko có thì thực hiện nều có thì quay lại for
                if (vt == a.length) {// kiểm tra vị trí có bằng với độ dài của keyword ko (với trường hợp sau khi chạy hết độ dài chuỗi)
                    vt = 0;//gắn vị trí = 0
                    c[vtt] = a[vt];//gán ký tự của keyword vào mảng c để chứa key
                    vt++;
                    vtt++;
                } else {//nếu vị trí của ký tự trong keyword khác với đồ dài của keyword
                    c[vtt] = a[vt];//gán ký tự của keyword vào mảng c để chứa key
                    vt++;
                    vtt++;
                }
            }
        }
        return c;
    }

    //phương thức mã hóa Vegenere
    public String maHoa() {
        String giaima = "";//khai báo chuỗi rỗng
        String ttt = this.textmahoa.toUpperCase();//chuyển đổi các chữ thường thành hoa
        char b[] = ttt.toCharArray();//chuyển đổi chuỗi nhập vào thành mảng
        char key[] = this.taokey();//khai báo biến key chứa key sau khi nhập keyword
        int vt = 0;
        for (int i = 0; i < b.length; i++) {//duyệt lần lượt các phần tử của chuỗi nhập vào theo độ dại chuỗi
            if ((char) b[i] != 32) {//nếu ký tự khác dấu cách
                int text = (((int) b[i] + (int) key[vt]) % 26) + 65;//lấy giá trị đầu của chuỗi và key cộng lại chia lấy dư cho 26, sau đó cộng 65
                giaima = giaima + (char) text;//chuyển giá trị của số vừa tính xong sang ký tự để xuất ra chữ
                vt++;
            } else {
                giaima = giaima + b[i];
            }
        }
        return giaima;
    }

    //phương thức giải mã Vegenere
    public String giaiMa() {
        String giaima = "";//khai báo chuỗi rỗng
        String ttt = this.textmahoa.toUpperCase();//chuyển đổi các chữ thường thành hoa
        char b[] = ttt.toCharArray();//chuyển đổi chuỗi nhập vào thành mảng
        char key[] = this.taokey();//khai báo biến key chứa key sau khi nhập keyword
        int vt = 0;
        for (int i = 0; i < b.length; i++) {//duyệt lần lượt các phần tử của chuỗi nhập vào theo độ dại chuỗi
            if ((char) b[i] != 32) {//nếu ký tự khác dấu cách
                int text = (((int) b[i] - (int) key[vt] + 26) % 26) + 65;//lấy giá trị đầu của chuỗi và key trừ nhau cộng 26 sau đó chia lấy dư cho 26, sau đó cộng 65
                System.out.println(text);
                giaima = giaima + (char) text;//chuyển giá trị của số vừa tính xong sang ký tự để xuất ra chữ
                vt++;
            } else {
                giaima = giaima + b[i];
            }
        }
        return giaima;
    }

    public static void main(String[] args) {
        Vegenere a = new Vegenere();
        a.setKey("he");
        a.setTextmahoa("AVBSUK KIW XYEP");
        System.out.println(a.giaiMa());
        System.out.println((65 - 72) % 26 + 65);
    }
}
