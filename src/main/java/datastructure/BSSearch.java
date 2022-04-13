package datastructure;//package mianshi;
//
///**
// * @Description TODO
// * @Date 2021/9/8 10:39 上午
// * @Created by Moon
// */
//public class BSSearch {
//    public static int search(int findnum,int [] a){
//        if(a==null||a.length==0){
//            return -1;
//        }
//        int left=0;
//        int right=a.length-1;
//        while (left<=right){
//            int mid=(left+right)/2;
//            if(a[mid]==findnum){
//                return mid;
//            }else  if(a[mid]>findnum){
//                right=mid-1;
//
//            } else if(a[mid]<findnum){
//            left=mid+1;
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args) {
//        int[] a={1,3,5,7,9};1,3,5,5,7,9
//        int num=5;
//        System.out.println(search(num,a));
//    }
//}
