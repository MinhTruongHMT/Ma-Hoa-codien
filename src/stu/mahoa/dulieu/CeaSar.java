package stu.mahoa.dulieu;

public class CeaSar {

    //khai báo các thuộc tính
    private String textip;
    private String textop;
    private int key;

    //khai báo các phương thức
    public CeaSar() {
    }

    public CeaSar(String textip, int key) {
        this.textip = textip;
        this.key = key;
    }

    public String getTextip() {
        return textip;
    }

    public void setTextip(String textip) {
        this.textip = textip;
    }

    public String getTextop() {
        return textop;
    }

    public void setTextop(String textop) {
        this.textop = textop;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    //phương thức mã hóa Ceasar
    public String maHoa() {
        char[] cd = this.textip.toCharArray();//chuyển các ký tự nhập vào thành chuỗi
        String text = "";//khai báo chuổi rỗng

        for (char c : cd) {//duyệt lần lượt các phần tử trong chuỗi vừa nhập vào
            if (c != ' ') {//nếu ký tự không phải dấu cách thì thực hiện
                int so;
                if ((int) c > 96) {//nếu ký tự không nằm trong khoảng từ 65-96 (biến chữ thường thành chữ hoa)
                    so = (int) c - 65 - 32;
                } else {
                    so = (int) c - 65;
                }
                so = (so + this.key) % 26;//thuật toán mã hóa ceasar
                text = text + (char) (so + 65);//ghép chuỗi đã có trước đó với số vừa tính ra cộng 65 thành mã ascii bảng chữ cái
            } else {//ngược lại nếu ký từ là khoảng trắng thì bỏ qua
                text = text + c;
            }
        }
        return text;
    }
    //phướng thức giải mã ceasar
    public String giaiMa() {
        char[] cd = this.textip.toCharArray();//chuyển các ký tự nhập vào thành chuỗi
        String text = "";//khai báo chuổi rỗng

        for (char c : cd) {//duyệt lần lượt các phần tử trong chuỗi vừa nhập vào
            if (c != ' ') {//nếu ký tự không phải dấu cách thì thực hiện
                int so;
                if ((int) c > 96) {//nếu ký tự không nằm trong khoảng từ 65-96 (biến chữ thường thành chữ hoa)
                    so = (int) c - 65 - 32;
                } else {
                    so = (int) c - 65;
                }
                so = (so - this.key + 26) % 26;//thuật toán giải mã ceasar
                text = text + (char) (so + 65);//ghép chuỗi đã có trước đó với số vừa tính ra cộng 65 thành mã ascii bảng chữ cái
            } else {
                text = text + c;//ngược lại nếu ký từ là khoảng trắng thì bỏ qua
            }
        }
        return text;
    }
    //phuognws thức kiểm tra key
    public boolean kiemTraKey() {
        if (this.key < 1) {//nếu key bé hơn 1 trả về false ngược lại trả về true
            return false;
        }
        return true;
    }
}
