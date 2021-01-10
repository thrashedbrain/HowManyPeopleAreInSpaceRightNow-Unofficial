package com.people.inspace.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {
    @SerializedName("number")
    private String count;

    @SerializedName("people")
    private List<Person> personList;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public class Person{
        @SerializedName("name")
        private String name;

        @SerializedName("title")
        private String title;

        @SerializedName("biolink")
        private String link_bio;

        @SerializedName("launchdate")
        private String launchdate;

        public String getLaunchdate() {
            return launchdate;
        }

        public void setLaunchdate(String launchdate) {
            this.launchdate = launchdate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink_bio() {
            return link_bio;
        }

        public void setLink_bio(String link_bio) {
            this.link_bio = link_bio;
        }
    }
}
