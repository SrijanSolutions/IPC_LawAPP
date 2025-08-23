package com.example.ipclawawareness;

public class Law {
        private String section;
        private String title;
        private String description;

        public Law() {
            // Required empty constructor for Firebase
        }

        public Law(String section, String title, String description) {
            this.section = section;
            this.title = title;
            this.description = description;
        }

        public String getSection() {
            return section;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }

