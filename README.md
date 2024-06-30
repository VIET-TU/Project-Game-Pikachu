 <h1>Dự án Java áp dụng design pattern MVC</h1>
    <h2>Các công nghệ sử dụng:</h2>
    <ul>
        <li>Java core: OOP, Collection (List, Set)</li>
        <li>Java Swing để tạo giao diện đồ họa</li>
        <li>Java AWT để xử lý sự kiện đầu vào</li>
        <li>Java sound: Xử lí phần âm thanh</li>
        <li>Java thread: xử lý các luồng chạy song song (ví dụ: nhạc, thời gian kết thúc)</li>
    </ul>
    <h2>Các chức năng:</h2>
    <ul>
        <li>
            <strong>Xây dựng thuật toán pikachu:</strong>
            Xây dựng ma trận chứa các ô pikachu một cách ngẫu nhiên, thuật toán tìm đường đi giữa 2 ô giống nhau.
        </li>
        <li>
            <strong>Xử lý sự kiện:</strong>
            Xử lý các sự kiện như click chuột, hover vào các ô, kiểm tra sự khớp nhau giữa các ô Pikachu để tạo ra điểm số.
        </li>
        <li>
            <strong>Thời gian chơi:</strong>
            Tạo ra tính năng đếm thời gian để người chơi có thể theo dõi thời gian chơi và kết thúc game khi hết giờ.
        </li>
        <li>
            <strong>Các cấp độ khác nhau:</strong>
            Tạo ra các cấp độ khác nhau với độ khó tăng dần, bao gồm 3 cấp độ chơi khác nhau và cho người chơi chọn lưới game phù hợp.
        </li>
        <li>
            <strong>Điểm số:</strong>
            Cập nhật điểm số của người chơi khi 2 ô được so khớp và hiển thị trên thanh bar.
        </li>
        <li>
            <strong>Âm thanh:</strong>
            Thêm các hiệu ứng âm thanh cho các hoạt động như lựa chọn, khớp thú Pikachu, hoàn thành trò chơi, nhạc nền.
        </li>
        <li>
            <strong>Hiệu ứng:</strong>
            Khi click vào ô hoặc khi hover vào sẽ set border cho các ô đó.
        </li>
        <li>
            <strong>Hiện thị bảng thông báo:</strong>
            Khi người chơi chiến thắng, hết giờ hoặc các option trên thanh menu.
            <ul>
                <li>Thanh option: có exit, tắt nhạc, pause game, new game.</li>
            </ul>
        </li>
        <li>
            <strong>Tạm dừng trò chơi:</strong>
            Khi tạm dừng trò chơi, nhạc và thời gian sẽ được tạm dừng và tiếp tục chạy khi người chơi bấm tiếp tục.
        </li>
        <li>
            <strong>Tối ưu hóa trò chơi:</strong>
            Cải thiện hiệu suất trò chơi bằng cách sử dụng cấu trúc dữ liệu và giải thuật tối ưu để giảm thiểu thời gian xử lý và tối đa hóa trải nghiệm người chơi.
        </li>
    </ul>

# Class

<p align="center">
 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/342160775_1727665067765704_2462337806352760305_n.png?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751302817&Signature=MyYaiBwbblodRt9GrhNZgwp29UE%3D"  alt="hrm image" />
</p>

# Giải thích chi tiết thuật toán tìm đường đi giữa 2 ô giống nhau: (Chi tiết có trong báo cáo)

- `Trường hợp nằm trên một cạnh (ngang hoặc dọc)`
<p align="center">
 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/Screenshot%202024-06-30%20231344.jpg?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751302085&Signature=RYOkdl0Uzt%2BYf1X0YIBFcsOH68U%3D"  alt="hrm image" />
</p>

- `Trường hộp  nối bằng tối đa 3 đoạn thẳng trong phạm vi hình chữ nhật hình thành từ tọa độ của 2 ô`
<p align="center">
 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/Screenshot%202024-06-30%20231359.jpg?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751302530&Signature=tD9BbbJnAeY8KpsIJnPo7OQ0UJo%3D"  alt="hrm image" />
</p>
 <p align="center">
 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/Screenshot%202024-06-30%20231415.jpg?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751302583&Signature=2CdaG6WHz%2Fwb8nHoxVyTENdQ2bc%3D"  alt="hrm image" />
</p>
 <p align="center">
 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/Screenshot%202024-06-30%20231223.jpg?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751302046&Signature=e2i4aycxvCd3%2FOl5DBWmCy9%2FFj0%3D"  alt="hrm image" />
 </p>

# Giao diện menu:

       <p align="center">

 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/Screenshot%202024-06-30%20221638.jpg?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751301708&Signature=1CZDs%2F2tK9om%2Ftd9sPgeWNEM6rk%3D"  alt="hrm image" />
</p>

# Giao diện khi vào game:

 <p align="center">
 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/Screenshot%202024-06-30%20221843.jpg?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751301801&Signature=ZfmFEU4%2BEnRIsPJFGJqb8luZP4k%3D"  alt="hrm image" />
</p>

<p align="center">
 <img src="https://rxjshop-s3-bucket.s3.ap-southeast-1.amazonaws.com/github/Screenshot%202024-06-30%20225708.jpg?AWSAccessKeyId=AKIAUGCNSNYC62XXGT6O&Expires=1751301865&Signature=%2FeoHjXA6iE3vRsC5ptwCAucD1G0%3D"  alt="hrm image" />
</p>

-
