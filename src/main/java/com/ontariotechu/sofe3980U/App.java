package com.ontariotechu.sofe3980U;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


import net.sf.javaml.clustering.*;
import net.sf.javaml.clustering.evaluation.Gamma;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;


public class App {

    //Define number of clusters 
    private static final int NumberofClusters = 4;

    public static void main(String[] args) throws Exception {

        //Load in the dataset with the numberofclusters previously defined (4)
        Dataset datairis = FileHandler.loadDataset(new File("src/main/dataset/iris.data"), NumberofClusters , ",");

        // Initialize/define the clusterer for the Kmeans algorithm
        Clusterer kMeans = new KMeans();

        // Initialize/define the clusterer for the Farthestfirst algorithm
        Clusterer FarF = new FarthestFirst();

        // Initialize/define the clusterer for the Kmedoids algorithm
        Clusterer Kmed = new KMedoids();


        //Execute the Kmeans clustering on the iris dataset by using the Kmeans clusterer previously initialized
        Dataset[] KMeansCluster = kMeans.cluster(datairis);
        // Evaluate the Kmeand clustering by using the Gamma evaluation method
        evaluateAlgorithm("KMeans", KMeansCluster);
          // Evaluate the Kmeand clustering by using the sumofsquared evaluation method
        SumofSquaredEvaluation("KMeans", KMeansCluster);
        //print the clusters/output generated for the Kmeans clustering algorithm
        ClustersOutput("KMeans", KMeansCluster);


       
       //Execute the FarthestFirst clustering on the iris dataset by using the FarthestFirst clusterer previously initialized
       Dataset[] FarthestFirstCluster = FarF.cluster(datairis);
        // Evaluate the FarthestFirst clustering by using the gamma evaluation method
        evaluateAlgorithm("FarthestFirst", FarthestFirstCluster);
         // Evaluate the FarthestFirst clustering by using the sumofsquared evaluation method
        SumofSquaredEvaluation("FarthestFirst", FarthestFirstCluster);
         //print the clusters/output generated for the Farthestfirst clustering algorithm
        ClustersOutput("FarthestFirst",  FarthestFirstCluster);



//Execute the KMedoids clustering on the iris dataset by using the KMedoids clusterer previously initialized
       Dataset[] KMedoidsCluster = Kmed.cluster(datairis);
         // Evaluate the Kmedoids clustering by using the gamma evaluation method
        evaluateAlgorithm("Kmedoids", KMedoidsCluster);
        // Evaluate the Kmedoids clustering by using the sumofsquared evaluation method
        SumofSquaredEvaluation("Kmedoids", KMedoidsCluster);
        //to print the output generated for the Kmedoids clustering algorithm
        ClustersOutput("KMedoids", KMedoidsCluster);


    }


    //Print the output(each instance) of the clusters generate by the 3 algorithms
    //Will print 4 cluster group outputs for each algorithm as defined previously by NumberofClusters
    private static void ClustersOutput(String algorithmName, Dataset[] clusters) {
        System.out.println( algorithmName + " Clusters(Output) are " + ":");
        //loops/iterates through each invidiual cluster and prints all its instances
        for (int i = 0; i < clusters.length; i++) {
         
            for (Instance instance : clusters[i]) {
                System.out.println(Arrays.toString(instance.values().toArray()));
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
    

     // uses gamma evaluation method to evaluate all 3 algorithms 
    
    private static void evaluateAlgorithm(String algorithmName, Dataset[] clusters) {

       //initializes gamma evaluation method to Euclidean
        ClusterEvaluation GammaEvalMethod = new Gamma(new net.sf.javaml.distance.EuclideanDistance());

        //calculates gamma score for each algorithm
        double ScoreGamma = GammaEvalMethod.score(clusters);
        // print gamma score 
        System.out.println("Gamma Cluster evaluation resulted in the Gamma Score of : " + ScoreGamma + "  for Algorithm  " + algorithmName);

    }

    // use sumofsquarederrors evaluation method to evaluate all 3 algorithms 
    
    private static void SumofSquaredEvaluation(String algorithmName, Dataset[] clusters) {

       //initializes sumofsquarederrors evaluation method to Euclidean
        ClusterEvaluation SumofSquaredMethod = new SumOfSquaredErrors(new net.sf.javaml.distance.EuclideanDistance());

          //calculates sumofsquared errors score for each algorithm
        double ScoreSumSquared = SumofSquaredMethod.score(clusters);

        // print sumofsquared errors score
        System.out.println("Sum of squared evaluation resulted in the Score of : " + ScoreSumSquared + "  for Algorithm  " + algorithmName);

    }

}