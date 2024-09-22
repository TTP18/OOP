package main;

import classes.hoadon;
import classes.nhacungcapvabanhang;
import classes.nhanvien;
import classes.thuocvakhachhang;


import java.util.* ;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader ;
import java.io.BufferedReader ;
import java.io.FileWriter;










class shopbanthuoc {


    public static void menuDSTHUOC(){
        Scanner sc = new Scanner(System.in);
        int i;
        thuocvakhachhang a = new thuocvakhachhang();
        thuocvakhachhang.DSTHUOC dsthuoc = a.new DSTHUOC();
        
        // DSTHUOC dsthuoc=new DSTHUOC();
        do{
            System.out.println("");
            System.out.println("");
            System.out.println("=========================DANH SACH THUOC=========================");
            System.out.println("|| 1. Nhap vao danh sach thuoc                                 ||");
            System.out.println("|| 2. Xuat ra danh sach thuoc                                  ||");
            System.out.println("|| 3. Them thuoc moi vao danh sach                             ||");
            System.out.println("|| 4. Them so luong thuoc                                      ||");
            System.out.println("|| 5. Xoa Thuoc khoi danh sach                                 ||");
            System.out.println("|| 6. Sua Thuoc                                                ||");
            System.out.println("|| 7. Tim Thuoc trong danh sach                                ||");
            System.out.println("|| 8. Doc file vao danh sach thuoc                             ||");
            System.out.println("|| 9. Ghi danh sach thuoc vao file                             ||");
            System.out.println("|| 10. Thoat                                                   ||");
            System.out.println("=================================================================");
                        System.out.println("");

            System.out.print("Nhap lua chon cua ban : ");
            i=sc.nextInt();
            switch (i)  {
                case 1:
                    dsthuoc.nhap();
                    break;
                case 2:
                    dsthuoc.xuat();
                    break;
                case 3:
                    dsthuoc.themthuocmoi();
                    break;
                case 4:
                    dsthuoc.them();
                    break;
                case 5:
                    dsthuoc.xoa();
                    break;
                case 6:
                    dsthuoc.sua();
                    break;
                case 7:
                    dsthuoc.tim();
                    break;
                case 8:
                    dsthuoc.DocFile();
                    break;
                case 9:
                    dsthuoc.GhiFile();
                    break;
                case 10:
                {
                    break;
                }
                default:
                    System.out.println("(!) Vui long nhap dung lua chon");
                    break;
            }
        }while(i!=10);


    }
    public static void menuDSNHANVIEN () {
        Scanner sc = new Scanner( System.in ) ;
        nhanvien a = new nhanvien();
        nhanvien.DSNhanVien d1 = a.new DSNhanVien();
        // DSNhanVien d1 = new DSNhanVien() ;
        int luachon = 0 ;
        while (luachon != 9){
            System.out.println("");
            System.out.println("==========================DANH SACH NHAN VIEN==========================");
            System.out.println("|| 1. Nhap danh sach nhan vien                                       ||");
            System.out.println("|| 2. Xuat danh sach nhan vien                                       ||");
            System.out.println("|| 3. Them 1 nhan vien vao sanh sach                                 ||");
            System.out.println("|| 4. Xoa 1 nhan vien khoi sanh sach bang ma nhan vien               ||");
            System.out.println("|| 5. Sua 1 nhan vien bang ma nhan vien                              ||");
            System.out.println("|| 6. Tim 1 nhan vien bang ma nhan vien                              ||");
            System.out.println("|| 7. Doc file vao danh sach nhan vien                               ||");
            System.out.println("|| 8. Ghi danh sach nhan vien vao File                               ||");
            System.out.println("|| 9.Thoat                                                           ||");
            System.out.println("=======================================================================");
                        System.out.println("");



            System.out.println(" Nhap lua chon cua ban :");
            luachon = sc.nextInt() ;
            switch(luachon){
                case 1 :
                    d1.nhap();
                    break ;
                case 2 :
                    d1.xuat();
                    break;
                case 3 :
                    d1.them();
                    break ;
                case 4 :
                    d1.xoa();
                    break ;
                case 5 :
                    d1.sua();
                    break ;
                case 6 :
                    d1.tim();
                    break;
                case 7 :
                    d1.DocFile();
                    break ;
                case 8 :
                    d1.GhiFile();
                    break ;
                case 9 :
                {
                    break;
                }
                default :
                    System.out.println("(!) VUi long nhap dung lua chon");
                    break ;
            }
        }

    }
    public static void menuDSNHACUNGCAP(){
        Scanner sc = new Scanner(System.in);
        int i;
        nhacungcapvabanhang a = new nhacungcapvabanhang();
        nhacungcapvabanhang.DSNHACUNGCAP dsnhacungcap = a.new DSNHACUNGCAP();
        // DSNHACUNGCAP dsnhacungcap=new DSNHACUNGCAP();
        do{
            System.out.println("");
            System.out.println("=========================DANH SACH NHA CUNG CAP=========================");
            System.out.println("||1. Nhap danh sach nha cung cap                                      ||");
            System.out.println("||2. Xuat danh sach nha cung cap                                      ||");
            System.out.println("||3. Xoa nha cung cap                                                 ||");
            System.out.println("||4. Them nha cung cap                                                ||");
            System.out.println("||5. Tim nha cung cap                                                 ||");
            System.out.println("||6. Sua nha cung cap                                                 ||");
            System.out.println("||7. Doc file vao danh sach nha cung cap                              ||");
            System.out.println("||8. Ghi danh sach nha cung cap vao file                              ||");
            System.out.println("||9. Thoat                                                            ||");
            System.out.println("========================================================================");
                        System.out.println("");


            System.out.print("Nhap lua chon cua ban : ");
            i=sc.nextInt();
            switch (i)  {
                case 1:
                    dsnhacungcap.nhap();
                    break;
                case 2:
                    dsnhacungcap.xuat();
                    break;
                case 3:
                    dsnhacungcap.xoa();
                    break;
                case 4:
                    dsnhacungcap.them();
                    break;
                case 5:
                    dsnhacungcap.tim();
                    break;
                case 6:
                    dsnhacungcap.sua();
                    break;
                case 7:
                    dsnhacungcap.DocFile();
                    break;
                case 8:
                    dsnhacungcap.GhiFile();
                    break;
                case 9:
                {
                    break;
                }
                default:
                    System.out.println("(!) VUi long nhap dung lua chon");
                    break;
            }

        }while( i != 9);


    }
    public static void menuDSHOADON()
    {
        Scanner sc=new Scanner(System.in);
        hoadon a = new hoadon();
        hoadon.DANHSACHHOADON dshd = a.new DANHSACHHOADON();
        // DANHSACHHOADON dshd=new DANHSACHHOADON();
        int choose=0;
        while (choose!=9)
        {
            System.out.println("");
            System.out.println("===================================DANH SACH HOA DON=======================================");
            System.out.println("|| 1. Nhap danh sach hoa don                                                             ||");
            System.out.println("|| 2. Xuat danh sach hoa don                                                             ||");
            System.out.println("|| 3. Them danh sach hoa don                                                             ||");
            System.out.println("|| 4. Xoa 1 hoa don bang ma hoa don                                                      ||");
            System.out.println("|| 5. Sua 1 hoa don bang ma hoa don                                                      ||");
            System.out.println("|| 6. Tim 1 hoa don bang ma hoa don                                                      ||");
            System.out.println("|| 7. Nhap du lieu tu file vao danh sach hoa don                                         ||");
            System.out.println("|| 8. Xuat du lieu tu danh sach hoa don ra file                                          ||");
            System.out.println("|| 9. Quay lai                                                                           ||");
            System.out.println("===========================================================================================");
                        System.out.println("");

            System.out.println("Nhap vao lua chon cua ban");
            choose=sc.nextInt();
            switch (choose)
            {
                case 1:
                {
                    dshd.nhap();
                    break;
                }
                case 2:
                {
                    dshd.xuat();
                    break;
                }
                case 3:
                {
                    dshd.them();
                    break;
                }
                case 4:
                {
                    dshd.xoa();
                    break;
                }
                case 5:
                {
                    dshd.sua();
                    break;
                }
                case 6:
                {
                    dshd.tim();
                    break;
                }
                case 7:
                {
                    dshd.DocFile();
                    break;
                }
                case 8:
                {
                    dshd.GhiFile();
                    break;
                }
                case 9:
                {
                    break;
                }
                default:
                {
                    System.out.println("(!) Vui long chi chon 1 trong 9 :))");
                    break;
                }

            }


        }
    }

    public static  void menuDSKHACHHANG(){
        Scanner sc = new Scanner(System.in);
        thuocvakhachhang a = new thuocvakhachhang();
        thuocvakhachhang.DSKHACHHANG dskhachhang = a.new DSKHACHHANG();
        // DSKHACHHANG dskhachhang=new DSKHACHHANG();
        int luachon=0;
        while (luachon!=9)
        {
            System.out.println("");
            System.out.println("=========================DANH SACH KHACH HANG=========================");
            System.out.println("|| 1. Nhap danh sach khach hang                                     ||");
            System.out.println("|| 2. Xuat danh sach khach hang                                     ||");
            System.out.println("|| 3. Xoa khach hang                                                ||");
            System.out.println("|| 4. Them khach hang                                               ||");
            System.out.println("|| 5. Tim khach hang                                                ||");
            System.out.println("|| 6. Sua khach hang                                                ||");
            System.out.println("|| 7. Doc file vao danh sach khach hang                             ||");
            System.out.println("|| 8. Ghi danh sach khach hang vao file                             ||");
            System.out.println("|| 9. Thoat                                                         ||");
            System.out.println("======================================================================");
                        System.out.println("");



            System.out.print("Nhap lua chon cua ban : ");
            luachon=sc.nextInt();

            switch (luachon)
            {
                case 1:
                    dskhachhang.nhap();
                    break;
                case 2:
                    dskhachhang.xuat();
                    break;
                case 3:
                    dskhachhang.xoa();
                    break;
                case 4:
                    dskhachhang.them();
                    break;
                case 5:
                    dskhachhang.tim();
                    break;
                case 6:
                    dskhachhang.sua();
                    break;
                case 7:
                    dskhachhang.DocFile();
                    break;
                case 8:
                    dskhachhang.GhiFile();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("(!) Vui long nhap dung lua chon");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        //Ham chay chuong trinh

        Scanner sc=new Scanner(System.in);
        int choose=0;
        while (choose!=6) {
            System.out.println("");
            System.out.println("");
            System.out.println("===========================================Quan Ly Hieu Thuoc===========================================");
            System.out.println("|| 1. Quan li thuoc                                                                                   ||");
            System.out.println("|| 2. Quan li khach hang                                                                              ||");
            System.out.println("|| 3. Quan li nhan vien                                                                               ||");
            System.out.println("|| 4. Quan li hoa don                                                                                 ||");
            System.out.println("|| 5. Quan li nha cung cap                                                                            ||");
            System.out.println("|| 6. Exist                                                                                           ||");
            System.out.println("========================================================================================================");
                        System.out.println("");

            
            System.out.println("Nhap vao lua chon cua ban");
            choose=sc.nextInt();

            switch (choose) {
                case 1:
                {
                    menuDSTHUOC();
                    break;

                }
                case 2:
                {
                    menuDSKHACHHANG();
                    break;

                }
                case 3:
                {
                    menuDSNHANVIEN();
                    break;

                }
                case 4:
                {
                    menuDSHOADON();
                    break;

                }
                case 5:
                {
                    menuDSNHACUNGCAP();
                    break;
                }
                case 6:
                {
                    System.out.println("Cam on da su dung chuong trinh nay!!!");
                    break;
                }

                default:
                {
                    System.out.println("(!) Vui long nhap dung lua chon");
                    break;
                }

            }
        }
    }
}


