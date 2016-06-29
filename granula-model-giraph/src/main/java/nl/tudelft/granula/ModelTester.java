package nl.tudelft.granula;

import nl.tudelft.granula.archiver.GranulaArchiver;
import nl.tudelft.granula.modeller.entity.BasicType.ArchiveFormat;
import nl.tudelft.granula.modeller.job.JobModel;
import nl.tudelft.granula.modeller.job.Overview;
import nl.tudelft.granula.modeller.platform.Giraph;
import nl.tudelft.granula.modeller.source.JobDirectorySource;

/**
 * Created by wing on 21-8-15.
 */
public class ModelTester {
    public static void main(String[] args) {

        String inputPath = "/home/wlngai/Workstation/Exec/Granula/debug/archiver/giraph/log";
//        String outputPath = "/home/wlngai/Workstation/Repo/tudelft-atlarge/granula/granula-visualizer/data/";
        String outputPath = "/home/wlngai/Workstation/Exec/Granula/debug/archiver/giraph/arc";

        // job
        JobDirectorySource jobDirSource = new JobDirectorySource(inputPath);
        jobDirSource.load();

        Overview overview = new Overview();
        overview.setStartTime(1466000574008l);
        overview.setEndTime(1466001551190l);
        overview.setName("Giraph Job");
        overview.setDescription("A Giraph Job");

        GranulaArchiver granulaArchiver = new GranulaArchiver(
                jobDirSource, new JobModel(new Giraph()), outputPath, ArchiveFormat.JS);
        granulaArchiver.setOverview(overview);
        granulaArchiver.archive();

    }
}
