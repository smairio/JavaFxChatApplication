module com.chatroom.chatroomfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.chatroom.chatroomfx to javafx.fxml;
    exports com.chatroom.chatroomfx;
}