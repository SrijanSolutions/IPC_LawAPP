package com.example.ipclawawareness;

public class Case {
    private String caseId;
    private String complainantName;
    private String complainantPhone;
    private String complainantAddress;
    private String accusedName;
    private String caseTitle;
    private String ipcSection;
    private String caseDescription;
    private String userId;
    private String date;
    private String status; // New field: "Filed", "Under Review", "In Progress", "Resolved"

    public Case() {
        // Default constructor required for Firebase
    }

    public Case(String caseId, String complainantName, String complainantPhone,
                String complainantAddress, String accusedName, String caseTitle,
                String ipcSection, String caseDescription, String userId,
                String date, String status) {
        this.caseId = caseId;
        this.complainantName = complainantName;
        this.complainantPhone = complainantPhone;
        this.complainantAddress = complainantAddress;
        this.accusedName = accusedName;
        this.caseTitle = caseTitle;
        this.ipcSection = ipcSection;
        this.caseDescription = caseDescription;
        this.userId = userId;
        this.date = date;
        this.status = status;
    }

    // Getters and setters for all fields
    public String getCaseId() { return caseId; }
    public void setCaseId(String caseId) { this.caseId = caseId; }

    public String getComplainantName() { return complainantName; }
    public void setComplainantName(String complainantName) { this.complainantName = complainantName; }

    public String getComplainantPhone() { return complainantPhone; }
    public void setComplainantPhone(String complainantPhone) { this.complainantPhone = complainantPhone; }

    public String getComplainantAddress() { return complainantAddress; }
    public void setComplainantAddress(String complainantAddress) { this.complainantAddress = complainantAddress; }

    public String getAccusedName() { return accusedName; }
    public void setAccusedName(String accusedName) { this.accusedName = accusedName; }

    public String getCaseTitle() { return caseTitle; }
    public void setCaseTitle(String caseTitle) { this.caseTitle = caseTitle; }

    public String getIpcSection() { return ipcSection; }
    public void setIpcSection(String ipcSection) { this.ipcSection = ipcSection; }

    public String getCaseDescription() { return caseDescription; }
    public void setCaseDescription(String caseDescription) { this.caseDescription = caseDescription; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
