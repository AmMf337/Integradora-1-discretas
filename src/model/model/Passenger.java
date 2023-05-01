package model;
public class Passenger {
    public String ticket;
    public String name;
    public Integer priority;
    public boolean isFirstClass;
    public int timeOfarrive;
    public int totalMiles;
    public String characteristics;
   
    public Passenger(String ticket,String name, int priority, int isFirstClass, int timeOfarrive,int totalMiles,String characteristics) {
        this.ticket = ticket;
        this.priority = priority;
        if(isFirstClass==1){
            this.isFirstClass = true;
        }else{
            this.isFirstClass = false;
        }
        this.timeOfarrive = timeOfarrive;
        this.name = name;
        this.totalMiles = totalMiles;
        this.characteristics = characteristics;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public int getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(int totalMiles) {
        this.totalMiles = totalMiles;
    }

    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public boolean isFirstClass() {
        return isFirstClass;
    }
    public void setFirstClass(boolean isFirstClass) {
        this.isFirstClass = isFirstClass;
    }
    public int getTimeOfarrive() {
        return timeOfarrive;
    }
    public void setTimeOfarrive(int timeOfarrive) {
        this.timeOfarrive = timeOfarrive;
    }
    public void calculateExitPrioryty(){
        Integer newPriority = 0;
        if(ticket.contains("C") || ticket.contains("D")){
            newPriority += 100;
        }else if(ticket.contains("B") || ticket.contains("E")){
            newPriority += 60;
        }else if(ticket.contains("A") || ticket.contains("F")){
            newPriority += 30;
        }
        if(ticket.contains("C") || ticket.contains("D")){
            newPriority += 100;
        }else if(ticket.contains("B") || ticket.contains("E")){
            newPriority += 60;
        }else if(ticket.contains("A") || ticket.contains("F")){
            newPriority += 30;
        }
        if(ticket.contains("1")){
            newPriority += 100;
        }else if(ticket.contains("2")){
            newPriority += 90;
        }else if(ticket.contains("3")){
            newPriority += 80;
        }else if(ticket.contains("4")){
            newPriority += 70;
        }else if(ticket.contains("5")){
            newPriority += 60;
        }else if(ticket.contains("6")){
            newPriority += 50;
        }else if(ticket.contains("7")){
            newPriority += 40;
        }else if(ticket.contains("8")){
            newPriority += 30;
        }else if(ticket.contains("9")){
            newPriority += 20;
        }else if(ticket.contains("10")){
            newPriority += 10;
        }
        setPriority(newPriority);
    }
}
