package com.swax.resumeapp.UI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swax.resumeapp.R;

import java.util.ArrayList;
import java.util.List;

import Model.Job;

public class ExperienceActivity extends AppCompatActivity {

    RecyclerView jobRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        jobRecyclerView = findViewById(R.id.job_list_recyclerview);
        final JobAdaptor adaptor = new JobAdaptor(this);
        jobRecyclerView.setAdapter(adaptor);
        jobRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor.setJobs(populateJobs());

    }

    public List<Job> populateJobs(){
        List<Job> list = new ArrayList<>();

        List<String> sMJobTasks = new ArrayList<>();
        sMJobTasks.add("Responsible for maintaining Java codebase for Android applications used by hundreds of thousands of users.");
        sMJobTasks.add("Built and maintained CI solutions in Bamboo and Team City for tracking and deploying content to multiple servers to support products in the field.");
        sMJobTasks.add("Tracked latest third party software releases to determine impact to our products and if we should upgrade or not.");
        sMJobTasks.add("Built new feature for serving video content in our platform utilizing MPV");
        sMJobTasks.add("Worked with product management and customers to define specifications and refine requirements into goals that are achievable while still meeting customer needs.");
        sMJobTasks.add("Maintained and completed fixes for reporting systems dealing with more than 100,000 active devices in the field.");
        sMJobTasks.add("Configured and maintained several Linux servers for development and deployment purposes.");
        sMJobTasks.add("Implemented support for special third party hardware in Android - creating engaging interactive user experiences.");
        sMJobTasks.add("Worked with some of the largest OEM’s to ensure product support on new devices and new versions of the Android Operating system.");
        Job smithMicro = new Job("Smith Micro Software", "Lead Software Developer", "Jan 2019 - Mar 2023", sMJobTasks);
        list.add(smithMicro);

        List<String> cMJobTasks = new ArrayList<>();
        cMJobTasks.add("Responsible for managing a team of 5 to 7 software developers and engineers (full time with contractor support) supporting a multi-million dollar business.");
        cMJobTasks.add("Maintained code base (both server side and client side) for device demos on Android and Windows Phone.");
        cMJobTasks.add("Maintained Android demo code that displays dynamically configurable content, logs and reports user activity and device information, caches content, and monitors device activity.");
        cMJobTasks.add("Configured and maintained server side code that ensures that the appropriate content and executable code is delivered to the devices in the field.");
        cMJobTasks.add("Configured and maintained reporting servers that collect and concatenate reporting data from the devices in the field.");
        cMJobTasks.add("Maintained code base for custom Android device management platform (both server side and client side).");
        cMJobTasks.add("Device management platform provides a high level of control over devices in the field, allowing for keeping the devices in a specific state (populate / clear data, some account information, homescreens, etc)");
        cMJobTasks.add("Ensured the stability of our platform on a device by device basis for each service update, ensuring that the application kept pace with the most recent Android / Windows Phone releases.");
        cMJobTasks.add("Collected specifications from clients and internal partners to build and maintain the product roadmap.");
        cMJobTasks.add("Worked with Sales to create trial products and participate in RFP’s.");
        cMJobTasks.add("Worked with all major OEM’s (Samsung, LG, HTC, Asus, Alcatel, Sony, ZTE, etc) on preloaded device management platform ensuring proper integration with device firmware.");
        cMJobTasks.add("Worked with a wide variety of consumer hardware - phones, tablets, cameras, speakers, phone cases, and wearables.");
        cMJobTasks.add("Helped to develop, deploy and maintain a web based UI to allow clients to directly manage demo devices in the field.");
        cMJobTasks.add("Managed and maintained release processes to ensure a high level of uptime for demo devices in the field.");
        cMJobTasks.add("Managed periods of very high release cadence without slipping dates - sometimes handling up to 35 releases in a month.");
        Job ismCm = new Job("Customer Mobile/ISM Connect", "Lead Software Engineer", "Apr 2012 - Jan 2019", cMJobTasks);
        list.add(ismCm);

        List<String> lexisTasks = new ArrayList<>();
        lexisTasks.add("Responsible for developing complex TSQL scripts, functions, and stored procedures with multiple layers of error checking and business logic in an environment with zero tolerance for faults.");
        lexisTasks.add("Tuned queries and stored procedures to allow them to run more efficiently across production DB’s spanning multiple environments, with 100’s of TB of data and tens of millions of document records.");
        lexisTasks.add("Built multiple break fix and investigation scripts to locate problems in production databases and then update those databases to ensure that clients are able to complete critical tasks on time.");
        lexisTasks.add("Worked with account managers, development teams, operations, and clients to determine requirements and feasibility of code customizations.");
        lexisTasks.add("Developed complex reports using TSQL for clients on data usage, types of documents, user interaction with our systems, and a variety of other requests not available through the standard reporting interface.");
        lexisTasks.add("Executed front end troubleshooting for webservers and SQL servers handling large scale enterprise web applications.");
        lexisTasks.add("Responsible for deployment of custom code, sprocs, functions and scripts to a live production environment.");
        lexisTasks.add("Responsible for troubleshooting ASP.net and Javascript code to narrow down problems before escalating to development.");
        lexisTasks.add("Responsible for troubleshooting and resolving issues with customer data to ensure that it is available for review.");
        lexisTasks.add("Managed the mediawiki and Sharepoint site for the entire data services engineering team");
        Job lexisNexus = new Job("LexisNexis Applied Discovery", "Data Services Engineer", "Jan 2012 - Nov 2012", lexisTasks);
        list.add(lexisNexus);

        List<String> msSupportEngineerTasks = new ArrayList<>();
        msSupportEngineerTasks.add("Supported 18 different tools used for serving advertising content, scheduling and pacing delivery of ads to end users, and finally reporting on the performance of those ads.");
        msSupportEngineerTasks.add("Worked with more than 30 different partner teams around the world, both internal and external to Microsoft.");
        msSupportEngineerTasks.add("Helped to create and iterate on scalable support processes, allowing the support team to increase our efficiency by nearly 30% year over year.");
        msSupportEngineerTasks.add("Created and communicated the business impact to development teams and product groups.");
        msSupportEngineerTasks.add("Played a key role in setting development priorities for a diverse toolset, representing key insights into supportability and customer impact.");
        msSupportEngineerTasks.add("Provided world class customer service through email, over the phone, and in person.");
        msSupportEngineerTasks.add("Culturally sensitive having worked with individuals in almost every country on the planet, particularly with western Europe (United Kingdom, France, Germany), Latin America (Mexico, Brazil), Japan, India and China.");
        msSupportEngineerTasks.add("Received and passed training in customer service essentials, effective listening, public speaking, and effective communication.");
        Job msSupportEngineer = new Job("Microsoft", "Support Engineer", "Apr 2009 - Dec 2011", msSupportEngineerTasks);
        list.add(msSupportEngineer);

        List<String> msSupportAssuranceTasks = new ArrayList<>();
        msSupportAssuranceTasks.add("Trained in Six Sigma process management and improvement methodologies.");
        msSupportAssuranceTasks.add("Helped to plan releases, set timelines, ensure adequate testing, and inform features needed to ensure that the business needs of advertisers were met by Microsoft’s offerings.issues both to drive development priorities and to ensure that support was prepared for likely issues.");
        msSupportAssuranceTasks.add("Provided both documentation and training for the support and sales teams.");
        msSupportAssuranceTasks.add("Created in-depth reports to meet business needs both on delivery and revenue associated with ads but also regarding workflow and processing.");
        msSupportAssuranceTasks.add("Participated in the development test cycle for new features, culminating in UAT and providing a critical go / no-go checkpoint in the release process.");
        msSupportAssuranceTasks.add("Served as the main point of contact with many downstream partners, ensuring that support was aware and prepared for each new innovation.");
        Job msSupportAssurance = new Job("Microsoft", "Support Assurance", "May 2008 - Dec 2009", msSupportAssuranceTasks);
        list.add(msSupportAssurance);

        List<String> msTSATasks = new ArrayList<>();
        msTSATasks.add("Provided administrative support for file shares, SQL servers and web servers for internal tools and services.");
        msTSATasks.add("Administration/Structuring of permissions on a business critical file share and web server utilized by over 100 users.");
        msTSATasks.add("Created data continuity plan implementing server backup and restoration process");
        msTSATasks.add("Maintenance on physical servers including software updates, hardware troubleshooting, wiring, network configuration, IIS configuration and SQL server configuration.");
        msTSATasks.add("Provided support to users through email, over the phone and in person, helping them to work in proprietary web tools.");
        msTSATasks.add("Diagnosed and troubleshot basic issues with the Microsoft advertising system, resolving issues when possible and escalating items determined to be legitimate bugs in the system.");
        msTSATasks.add("Helped users to resolve local installation issues involving .net components necessary to work with the web based toolset.");
        Job msTSA = new Job("Microsoft", "Technical Support Analyst", "Oct 2000 - May 2008", msTSATasks);
        list.add(msTSA);

        List<String> floorwatchTasks = new ArrayList<>();
        floorwatchTasks.add("Provided T2 support for the Amazon.com website and internal toolset.");
        floorwatchTasks.add("Collected and verified issues from the tier 1 customer service group, validated issues, resolved when able and escalated when necessary.");
        floorwatchTasks.add("Troubleshot issues with HTML on the live site.");
        floorwatchTasks.add("Maintained the Floorwatch webportal and provided communication on the current status of issues and bugs to the world wide Amazon.com customer service organization.");
        floorwatchTasks.add("Worked in both Windows and Unix systems to troubleshoot and resolve simple server issues using a variety of command line tools.");
        floorwatchTasks.add("Handled especially complicated customer phone calls, serving as an escalation point for tier 1 customer service reps.");
        Job floorwatch = new Job("Amazon", "Floorwatch", "Sep 1999 - Oct 2000", floorwatchTasks);
        list.add(floorwatch);

        return list;
    }
}
