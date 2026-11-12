# 📖 NGÀY 1: NỀN TẢNG DỮ LIỆU & BẢN CHẤT LƯU TRỮ

---

## PHẦN 1: CẤU TRÚC DỮ LIỆU & GIẢI THUẬT (HASH MAP & TWO SUM)

### 1. Bản chất bên dưới (Under the hood) của Hash Map trong Java
`HashMap` trong Java bản chất là một **mảng các danh sách liên kết (Array of Buckets)**.

```
Key: "apple" 
    │
    ▼ (Gọi hàm băm)
hashCode() = 2154245
    │
    ▼ (Chia lấy dư theo kích thước mảng: hash % array_length)
Index = 3
    │
    ▼
Array[3] ──> [ Node: ("apple", 100) ] ──> null
```

* **Quy trình lưu trữ (`put(key, value)`):**
  1. Java gọi hàm `key.hashCode()` để sinh ra một số nguyên.
  2. Dùng phép toán bit / chia dư (`hash & (length - 1)`) để tính ra vị trí ô trong mảng (**Bucket Index**).
  3. Lưu cặp `(key, value)` vào bucket đó.
* **Tại sao truy xuất (`get(key)`) lại đạt $O(1)$?**
  * Vì việc tìm ô trong mảng qua chỉ số (Index) `Array[3]` diễn ra ngay lập tức với thời gian hằng số ($O(1)$).

### 2. Xung đột băm (Hash Collision) & Cơ chế giải quyết
Nếu hai key khác nhau tình cờ tính ra cùng một Index:
* **Kỹ thuật Chaining (Nối chuỗi):** Java nối các phần tử chung ô lại thành một **Danh sách liên kết đơn (Singly Linked List)**.
* **Cải tiến quan trọng từ Java 8:**
  * Nếu nhiều phần tử rơi vào cùng 1 ô khiến Linked List dài **$\ge 8$ phần tử** (TREEIFY_THRESHOLD), Java sẽ tự động chuyển Linked List đó thành **Cây đỏ - đen (Red-Black Tree)**.
  * *Tại sao?* Vì tìm kiếm trên Linked List tốn $O(n)$, còn trên Red-Black Tree chỉ tốn **$O(\log n)$**.
* **Độ phức tạp:**
  * Thời gian trung bình: $O(1)$.
  * Trường hợp tệ nhất (Worst Case): $O(\log n)$ (từ Java 8) hoặc $O(n)$.
  * Không gian: $O(n)$.

### 3. Kỹ thuật giải Two Sum bằng Hash Map (One-pass Hash Table)
* Đề bài: Cho mảng `nums` và số `target`. Tìm 2 vị trí sao cho `nums[i] + nums[j] = target`.
* Biến đổi toán học: $b = \text{target} - a$.
* **Cách thiết lập Hash Map:**
  * **Key:** Lưu giá trị của phần tử (số $a$).
  * **Value:** Lưu vị trí của phần tử đó trong mảng (index `i`).
* **Thuật toán 1 vòng lặp ($O(n)$):**
  1. Duyệt qua từng số `nums[i]`.
  2. Tính số bù: `complement = target - nums[i]`.
  3. Kiểm tra: `if (map.containsKey(complement))` -> Trả về `[map.get(complement), i]`.
  4. Nếu chưa có: `map.put(nums[i], i)`.

---

## PHẦN 2: JAVA CORE & NỀN TẢNG KHOA HỌC MÁY TÍNH

### 1. Phân biệt bộ nhớ Stack và Heap

| Đặc điểm | Bộ nhớ STACK | Bộ nhớ HEAP |
| :--- | :--- | :--- |
| **Bản chất lưu trữ** | Chứa các biến cục bộ nguyên thủy (`int`, `boolean`,...) và **địa chỉ con trỏ tham chiếu**. | Chứa **đối tượng thực tế (Object)** được tạo ra bằng từ khóa `new`. |
| **Phạm vi (Scope)** | Riêng biệt cho từng Thread (Thread-safe). Khi gọi hàm xong, Stack Frame tự động bị hủy. | Dùng chung cho toàn bộ ứng dụng (Shared across threads). |
| **Cơ chế thu dọn** | Tự động giải phóng cực nhanh theo nguyên lý LIFO (Last In First Out). | Do **Garbage Collector (Bộ thu dọn rác - GC)** quét và giải phóng ngầm. |
| **Lỗi tràn bộ nhớ** | `java.lang.StackOverflowError` (thường do đệ quy vô tận). | `java.lang.OutOfMemoryError` (do tạo quá nhiều object mà GC không dọn kịp). |

### 2. Tại sao `String` trong Java lại là Immutable (Bất biến)?
* **Bản chất:** Khai báo là `public final class String { private final byte[] value; }`.
* **3 Lý do sống còn:**
  1. **String Constant Pool:** Tiết kiệm RAM bằng cách tái sử dụng chuỗi dùng chung.
  2. **An toàn đa luồng (Thread-Safety):** Bất biến nên không bao giờ bị Race Condition khi nhiều Thread cùng đọc.
  3. **Bảo mật (Security):** Tránh bị can thiệp sửa đổi URL kết nối DB, username/password trong lúc runtime.

---

## PHẦN 3: CƠ SỞ DỮ LIỆU CHUYÊN SÂU (B-TREE INDEXING)

### 1. Tại sao bảng lớn không có Index thì SELECT lại chậm?
* Cơ sở dữ liệu lưu theo khối **Data Page / Block** (8KB).
* Không có Index -> **Full Table Scan** (quét tuần tự từ đầu đến cuối hàng triệu dòng) -> Gây nghẽn đĩa (Disk I/O).

### 2. Cây B-Tree (Balanced Tree)
* Fan-out lớn: Mỗi node chứa hàng trăm khóa.
* Bảng 10 triệu dòng chỉ cao 3-4 tầng -> Chỉ tốn **3-4 lần đọc đĩa (I/O)**.
* Độ phức tạp giảm từ **$O(n)$ xuống $O(\log n)$**.

### 3. Đánh đổi (Trade-off): Tại sao không đánh Index bừa bãi?
1. **Làm chậm thao tác GHI (`INSERT`, `UPDATE`, `DELETE`):** Phải tính toán và cân bằng lại cây B-Tree, dễ bị tách node (**Page Split**).
2. **Tốn dung lượng đĩa và RAM:** File Index có thể lớn hơn dữ liệu bảng và làm tràn bộ đệm RAM (Buffer Pool).

---

## PHẦN 4: THIẾT KẾ SCHEMA ENTERPRISE CHUẨN MỰC
1. **Primary Key:** Dùng `BIGSERIAL` / `BIGINT`.
2. **Many-to-Many:** Dùng bảng trung gian `user_roles(user_id, role_id)`.
3. **Audit Columns:** `created_at`, `updated_at`.
4. **Soft Delete:** `is_deleted BOOLEAN DEFAULT FALSE`.
5. **Constraints:** `sku` UNIQUE NOT NULL, `email` UNIQUE NOT NULL.
