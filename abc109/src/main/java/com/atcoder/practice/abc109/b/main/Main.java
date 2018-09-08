package com.atcoder.practice.abc109.b.main;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        String[] w = makeArray(n, sc);
        if (!check(w)) {
           System.out.println("No");
           return;
        }
        if (!shiritori(w)) {
            System.out.println("No");
            return;
         }
        System.out.println("Yes");
    }
    
    private boolean check(String[] w) {
        for (int i = 0; i < w.length; i++) {
            String str = w[i];
            for (int j = 0; j < w.length; j++) {
                if (i == j) {
                    continue;
                }
                if (str.equals(w[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean shiritori(String[] w) {
        for (int i = 0; i < w.length - 1; i++) {
            String str = w[i];
            String next = w[i + 1];
            String[] strSplit = str.split("");
            String[] nextSplit = next.split("");
            if (!strSplit[strSplit.length - 1].equals(nextSplit[0])) {
                return false;
            }
        }
        return true;
    }
    
    private String[] makeArray(int max, FastScanner sc) {
        String[] array = new String[max];
        for (int i = 0; i < max; i++) {
            array[i] = sc.next();
        }
        return array;
    }
    
    
    class FastScanner implements Closeable{
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }else{
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while(true){
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                }else if(b == -1 || !isPrintableChar(b)){
                    return minus ? -n : n;
                }else{
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }
        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }
        public double nextDouble() { return Double.parseDouble(next());}
        public void close() throws IOException {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
    }
}
