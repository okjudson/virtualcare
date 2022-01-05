package edu.virtualcare.lista;

import java.io.Serializable;

public class UserModel implements Serializable {

        private String userName;



        public UserModel(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }


    private String userSite;
    public void UserModelSite(String userSite) {
        this.userSite = userSite;
    }

    public String getUserSite() {        return userSite;    }

    public void setUserSite(String userSite) {        this.userSite = userSite;    }
}

