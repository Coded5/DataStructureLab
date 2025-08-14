package logic;

import java.util.ArrayList;

public class Region {

    private String name;
    private ArrayList<Player> playerList;
    private ArrayList<Quest> questList;

    public Region(String name) {
        this.playerList = new ArrayList<>();
        this.questList = new ArrayList<>();
        this.setName(name);
    }
    
    public void setName(String name) {
        if (name.isBlank())
            this.name = "Nowhere";
        else
            this.name = name;
    }

    public int getPlayerCount() {
        return playerList.size();
    }

    public double getRegionRank() {
        double sum = 0;

        for (Player player : playerList) {
            sum += player.getRank();
        }

        double average = sum / playerList.size();
        return Math.round(average * 100d) / 100d;
    }

    public ArrayList<Quest> getAvailableQuests(Player viewer) {
        ArrayList<Quest> query = new ArrayList<>();

        for (Quest quest : questList) {
            if (quest.getStatus() == Status.AVAILABLE && !quest.getAuthor().equals(viewer)) {
                query.add(quest);
            }
        }
        
        return query;
    }

    public void addPlayerToRegion(Player player) {
        playerList.add(player);
    }

    public void addQuestToRegion(Quest quest) {
        questList.add(quest);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(ArrayList<Quest> questList) {
        this.questList = questList;
    }



}
