package jukebox_project;

public class Users {
    private int userId;

        private String UserName;
        private String password;

        public Users() {}

        public Users(int userId, String userName, String password) {
            this.userId = userId;

           this.UserName = userName;
            this.password = password;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }


        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User_Details{" +
                    "userId=" + userId +

                    ", UserName='" + UserName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

