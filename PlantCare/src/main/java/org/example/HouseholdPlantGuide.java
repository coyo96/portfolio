import java.util.*;

public class HouseholdPlantGuide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Household Plant Guide!");

        // Plant genera, species, care instructions, and physical attributes
        Map<String, String[]> plantSpecies = new TreeMap<>();
        plantSpecies.put("Calathea", new String[] {
                "Calathea orbifolia (Orbifolia)",
                "Calathea lancifolia (Rattlesnake Plant)",
                "Calathea medallion (Calathea veitchiana)",
                "Calathea rufibarba (Furry Feather Calathea)",
                "Calathea zebrina (Zebra Plant)"
        });
        plantSpecies.put("Dracaena", new String[] {
                "Dracaena compacta (Compact Dracaena)",
                "Dracaena fragrans (Corn Plant)",
                "Dracaena marginata (Dragon Tree)",
                "Dracaena reflexa (Song of India)",
                "Dracaena sanderiana (Lucky Bamboo)"
        });
        plantSpecies.put("Ficus", new String[] {
                "Ficus benjamina (Weeping Fig)",
                "Ficus elastica (Rubber Plant)",
                "Ficus lyrata (Fiddle-Leaf Fig)",
                "Ficus microcarpa (Indian Laurel)",
                "Ficus pumila (Creeping Fig)"
        });
        plantSpecies.put("Monstera", new String[] {
                "Monstera adansonii (Swiss Cheese Vine)",
                "Monstera deliciosa (Swiss Cheese Plant)",
                "Monstera obliqua (Swiss Cheese Plant)",
                "Monstera pinnatipartita (Split Leaf Philodendron)",
                "Monstera standleyana (Five-Hole Plant)"
        });
        plantSpecies.put("Pothos", new String[] {
                "Epipremnum aureum (Golden Pothos)",
                "Epipremnum manjula (Manjula Pothos)",
                "Epipremnum marble queen (Marble Queen Pothos)",
                "Epipremnum neon (Neon Pothos)",
                "Epipremnum pictum (Satin Pothos)"
        });
        plantSpecies.put("Sansevieria", new String[] {
                "Sansevieria cylindrica (Cylindrical Snake Plant)",
                "Sansevieria laurentii (Variegated Snake Plant)",
                "Sansevieria moonshine (Moonshine Snake Plant)",
                "Sansevieria trifasciata (Snake Plant)",
                "Sansevieria zeylanica (Bowstring Hemp)"
        });

        // Care instructions for the plants
        Map<String, String> plantCareInstructions = new HashMap<>();
        plantCareInstructions.put("Calathea orbifolia (Orbifolia)", "Calathea orbifolia prefers bright, indirect light. Keep the soil evenly moist, but not soggy. Maintain high humidity levels by misting the leaves.");
        plantCareInstructions.put("Calathea lancifolia (Rattlesnake Plant)", "Calathea lancifolia prefers bright, indirect light. Keep the soil evenly moist, but not soggy. Maintain high humidity levels.");
        plantCareInstructions.put("Calathea medallion (Calathea veitchiana)", "Calathea medallion thrives in bright, indirect light. Keep the soil evenly moist, but not soggy. Maintain high humidity levels.");
        plantCareInstructions.put("Calathea rufibarba (Furry Feather Calathea)", "Calathea rufibarba prefers bright, indirect light. Keep the soil evenly moist, but not soggy. Maintain high humidity levels.");
        plantCareInstructions.put("Calathea zebrina (Zebra Plant)", "Calathea zebrina thrives in bright, indirect light. Keep the soil evenly moist, but not soggy. Maintain high humidity levels.");

        plantCareInstructions.put("Dracaena compacta (Compact Dracaena)", "Dracaena compacta prefers bright, indirect light. Water when the top inch of soil is dry. Avoid overwatering.");
        plantCareInstructions.put("Dracaena fragrans (Corn Plant)", "Dracaena fragrans can tolerate a range of light conditions, from low to bright indirect light. Water when the top inch of soil is dry. Avoid overwatering.");
        plantCareInstructions.put("Dracaena marginata (Dragon Tree)", "Dracaena marginata prefers bright, indirect light. Water when the top inch of soil is dry. Avoid overwatering.");
        plantCareInstructions.put("Dracaena reflexa (Song of India)", "Dracaena reflexa thrives in bright, indirect light. Water when the top inch of soil is dry. Avoid overwatering.");
        plantCareInstructions.put("Dracaena sanderiana (Lucky Bamboo)", "Dracaena sanderiana can tolerate various light conditions, from low to bright indirect light. Keep the water level just covering the roots and replace it every 1-2 weeks.");

        plantCareInstructions.put("Ficus benjamina (Weeping Fig)", "Ficus benjamina prefers bright, indirect light. Water when the top inch of soil is dry. Avoid overwatering and sudden temperature changes.");
        plantCareInstructions.put("Ficus elastica (Rubber Plant)", "Ficus elastica thrives in bright, indirect light. Water when the top inch of soil is dry. Avoid overwatering and cold drafts.");
        plantCareInstructions.put("Ficus lyrata (Fiddle-Leaf Fig)", "Ficus lyrata prefers bright, indirect light. Water when the top inch of soil is dry. Avoid overwatering.");
        plantCareInstructions.put("Ficus microcarpa (Indian Laurel)", "Ficus microcarpa prefers bright, indirect light. Water when the top inch of soil is dry. Prune regularly to maintain shape.");
        plantCareInstructions.put("Ficus pumila (Creeping Fig)", "Ficus pumila can tolerate various light conditions, from low to bright indirect light. Water when the top inch of soil is dry. Provide support for climbing.");

        plantCareInstructions.put("Monstera adansonii (Swiss Cheese Vine)", "Monstera adansonii thrives in bright, indirect light. Water when the top inch of soil is dry. Allow the soil to dry slightly between waterings.");
        plantCareInstructions.put("Monstera deliciosa (Swiss Cheese Plant)", "Monstera deliciosa prefers bright, indirect light. Water when the top inch of soil is dry. Provide support for climbing.");
        plantCareInstructions.put("Monstera obliqua (Swiss Cheese Plant)", "Monstera obliqua requires bright, indirect light and high humidity. Water when the top inch of soil is dry.");
        plantCareInstructions.put("Monstera pinnatipartita (Split Leaf Philodendron)", "Monstera pinnatipartita prefers bright, indirect light. Water when the top inch of soil is dry. Provide support for climbing.");
        plantCareInstructions.put("Monstera standleyana (Five-Hole Plant)", "Monstera standleyana prefers bright, indirect light. Water when the top inch of soil is dry. Provide support for climbing.");

        plantCareInstructions.put("Epipremnum aureum (Golden Pothos)", "Epipremnum aureum can tolerate a range of light conditions, from low to bright indirect light. Water when the top inch of soil is dry. Allow the soil to dry slightly between waterings.");
        plantCareInstructions.put("Epipremnum manjula (Manjula Pothos)", "Epipremnum manjula prefers bright, indirect light. Water when the top inch of soil is dry. Allow the soil to dry slightly between waterings.");
        plantCareInstructions.put("Epipremnum marble queen (Marble Queen Pothos)", "Epipremnum marble queen thrives in bright, indirect light. Water when the top inch of soil is dry. Allow the soil to dry slightly between waterings.");
        plantCareInstructions.put("Epipremnum neon (Neon Pothos)", "Epipremnum neon can tolerate a range of light conditions, from low to bright indirect light. Water when the top inch of soil is dry. Allow the soil to dry slightly between waterings.");
        plantCareInstructions.put("Epipremnum pictum (Satin Pothos)", "Epipremnum pictum prefers bright, indirect light. Water when the top inch of soil is dry. Allow the soil to dry slightly between waterings.");

        plantCareInstructions.put("Sansevieria cylindrica (Cylindrical Snake Plant)", "Sansevieria cylindrica prefers bright, indirect light. Water when the top inch of soil is dry. Allow the soil to dry between waterings.");
        plantCareInstructions.put("Sansevieria laurentii (Variegated Snake Plant)", "Sansevieria laurentii can tolerate various light conditions, from low to bright indirect light. Water sparingly and allow the soil to dry between waterings.");
        plantCareInstructions.put("Sansevieria moonshine (Moonshine Snake Plant)", "Sansevieria moonshine is a compact snake plant variety that thrives in bright, indirect light. Water when the top inch of soil is dry. Allow the soil to dry between waterings.");
        plantCareInstructions.put("Sansevieria trifasciata (Snake Plant)", "Sansevieria trifasciata can tolerate various light conditions, from low to bright indirect light. Water sparingly and allow the soil to dry between waterings.");
        plantCareInstructions.put("Sansevieria zeylanica (Bowstring Hemp)", "Sansevieria zeylanica prefers bright, indirect light. Water when the top inch of soil is dry. Allow the soil to dry between waterings.");

        System.out.println("Select a plant genus (1-6):");

        int i = 1;
        for (String genus : plantSpecies.keySet()) {
            System.out.println(i + ". " + genus);
            i++;
        }

        int genusSelection = scanner.nextInt();
        scanner.nextLine();

        if (genusSelection >= 1 && genusSelection <= plantSpecies.size()) {
            String selectedGenus = (String) plantSpecies.keySet().toArray()[genusSelection - 1];
            String[] selectedSpecies = plantSpecies.get(selectedGenus);

            System.out.println("\nSelected genus: " + selectedGenus);
            System.out.println("Select a plant species (1-5):");

            Arrays.sort(selectedSpecies); // Sort species alphabetically

            int j = 1;
            for (String species : selectedSpecies) {
                System.out.println(j + ". " + species);
                j++;
            }

            int speciesSelection = scanner.nextInt();
            scanner.nextLine();

            if (speciesSelection >= 1 && speciesSelection <= selectedSpecies.length) {
                String selectedSpeciesName = selectedSpecies[speciesSelection - 1];
                String careInstructions = plantCareInstructions.get(selectedSpeciesName);
                String physicalAttributes = getPhysicalAttributes(selectedSpeciesName);

                System.out.println("\nSelected species: " + selectedSpeciesName);
                System.out.println("Care Instructions:");
                System.out.println(careInstructions);
                System.out.println("\nPhysical Attributes:");
                System.out.println(physicalAttributes);
            } else {
                System.out.println("Invalid selection.");
            }
        } else {
            System.out.println("Invalid selection.");
        }

        scanner.close();
    }

    private static String getPhysicalAttributes(String species) {
        // Provide the physical attributes of each species here or implement logic to retrieve the information from a data source
        // Return a string describing the physical attributes of the species
        return "Physical attributes for " + species + " go here.";
    }
}
