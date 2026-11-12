# 🎯 BỘ CÂU HỎI PHỎNG VẤN CHUYÊN SÂU: JAVA CORE & MEMORY

### Q1: Phân biệt bộ nhớ Stack và Heap trong JVM?
- **Stack**: Lưu biến nguyên thủy cục bộ, con trỏ tham chiếu, stack frames theo từng luồng (Thread-isolated).
- **Heap**: Lưu đối tượng thực tế được cấp phát bằng từ khóa `new`, chia sẻ cho toàn bộ ứng dụng (Thread-shared), được quản lý bởi Garbage Collector (GC).
- **Lỗi điển hình**: StackOverflowError vs OutOfMemoryError.

### Q2: Tại sao String trong Java lại bất biến (Immutable)?
1. **String Constant Pool**: Tiết kiệm bộ nhớ heap.
2. **Thread Safety**: An toàn khi truy cập đồng thời giữa các luồng.
3. **Security**: Tránh bị thay thế thông tin nhạy cảm (DB URL, username, password) tại runtime.
4. **Caching HashCode**: Tính toán hashcode 1 lần duy nhất, tối ưu khi dùng làm Key trong HashMap/HashSet.

### Q3: Bản chất HashMap hoạt động ra sao và cải tiến từ Java 8?
- Mảng các bucket kết hợp Chaining (Linked List).
- Java 8: Khi một bucket có độ dài $\ge 8$ phần tử (TREEIFY_THRESHOLD), tự động chuyển sang Red-Black Tree để giảm độ phức tạp tìm kiếm từ $O(n)$ xuống $O(\log n)$.
