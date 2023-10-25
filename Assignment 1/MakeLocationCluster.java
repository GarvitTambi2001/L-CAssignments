import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Location {
    String name;
    double latitude;
    double longitude;

    Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

public class MakeLocationCluster {
    public static void main(String[] args) {
        double clusteringRadius = 10.0;
        List<Location> locations = readLocationsFromCSV();
        List<List<Location>> clusters = clusterLocations(locations, clusteringRadius);
        displayClusters(clusters);
    }

    private static List<Location> readLocationsFromCSV() {
        List<Location> locations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/InputData.csv"))) {
            br.readLine(); // Skip the header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double latitude = parseLatitude(parts[1].trim());
                double longitude = parseLongitude(parts[2].trim());
                locations.add(new Location(name, latitude, longitude));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return locations;
    }

    private static double parseLatitude(String latitude) {
        String[] parts = latitude.split("° |' |\" | ");
        return Double.parseDouble(parts[0]);
    }

    private static double parseLongitude(String longitude) {
        String[] parts = longitude.split("° |' |\" | ");
        return Double.parseDouble(parts[0]);
    }

    private static List<List<Location>> clusterLocations(List<Location> locations, double clusteringRadius) {
        List<List<Location>> clusters = new ArrayList<>();
        for (Location location : locations) {
            boolean addedToCluster = false;
            for (List<Location> cluster : clusters) {
                Location referenceLocation = cluster.get(0);
                if (isWithinRadius(location, referenceLocation, clusteringRadius)) {
                    cluster.add(location);
                    addedToCluster = true;
                    break;
                }
            }
            if (!addedToCluster) {
                List<Location> newCluster = new ArrayList<>();
                newCluster.add(location);
                clusters.add(newCluster);
            }
        }
        return clusters;
    }

    private static boolean isWithinRadius(Location currentLocation, Location referenceLocation, double clusteringRadius) {
        double lat1 = Math.toRadians(currentLocation.latitude);
        double lat2 = Math.toRadians(referenceLocation.latitude);
        double dLat = lat2 - lat1;
        double dLon = Math.toRadians(referenceLocation.longitude - currentLocation.longitude);
        double harvesineFormulae = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double centralAngle = 2 * Math.atan2(Math.sqrt(harvesineFormulae), Math.sqrt(1 - harvesineFormulae));
        double distance = 6371.0 * centralAngle;
        return distance <= clusteringRadius;
    }

    private static void displayClusters(List<List<Location>> clusters) {
        System.out.println("Location Clusters:");
        int clusterNumber = 1;
        for (List<Location> cluster : clusters) {
            System.out.println("Cluster " + clusterNumber + ":");
            for (Location location : cluster) {
                System.out.println(location.name);
            }
            clusterNumber++;
            System.out.println();
        }
    }
}