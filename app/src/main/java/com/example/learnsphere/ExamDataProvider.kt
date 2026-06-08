package com.example.learnsphere

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color

object ExamDataProvider {
    fun getExamData(examId: String): PremiumExamData? {
        return when (examId) {
            // --- SCIENCE STREAM ---
            "jee_main_adv" -> PremiumExamData(
                examName = "JEE Main & Advanced",
                description = "Expert-led curriculum for IIT & NIT aspirants",
                bannerColors = listOf(Color(0xFF1E3A8A), Color(0xFF1E40AF)),
                subjects = listOf(
                    SubjectInfo("Physics", Icons.Default.FlashOn, Color(0xFFF59E0B)),
                    SubjectInfo("Chemistry", Icons.Default.Science, Color(0xFF10B981)),
                    SubjectInfo("Mathematics", Icons.Default.Functions, Color(0xFFEF4444))
                ),
                mockTests = listOf(
                    MockTestInfo("All India Mock Test 2024", "3 Hours • 180 Marks"),
                    MockTestInfo("Previous Year Paper 2023", "Full Length • Solutions Included", Color(0xFF38BDF8))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Calculus Drill", "DPP"),
                    PracticeSheetInfo("Organic Reaction Mech", "Formula Sheet"),
                    PracticeSheetInfo("10-Year PYQ Bank", "PYQ")
                )
            )
            "neet" -> PremiumExamData(
                examName = "NEET-UG",
                description = "Top medical college entrance preparation",
                bannerColors = listOf(Color(0xFF065F46), Color(0xFF064E3B)),
                subjects = listOf(
                    SubjectInfo("Biology", Icons.Default.Spa, Color(0xFF10B981)),
                    SubjectInfo("Physics", Icons.Default.FlashOn, Color(0xFFF59E0B)),
                    SubjectInfo("Chemistry", Icons.Default.Science, Color(0xFF38BDF8))
                ),
                mockTests = listOf(
                    MockTestInfo("National NEET Mock 2024", "200 Questions • 720 Marks"),
                    MockTestInfo("PYP 2023 Analysis", "With Detailed Video Solutions", Color(0xFF10B981))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Human Physiology", "DPP"),
                    PracticeSheetInfo("Periodic Table Trends", "Cheat Sheet"),
                    PracticeSheetInfo("NEET 2022 Solved", "PYQ")
                )
            )
            "nda" -> PremiumExamData(
                examName = "NDA / NA",
                description = "Join the elite Indian Armed Forces",
                bannerColors = listOf(Color(0xFF991B1B), Color(0xFF7F1D1D)),
                subjects = listOf(
                    SubjectInfo("Mathematics", Icons.Default.Functions, Color(0xFFEF4444)),
                    SubjectInfo("General Ability", Icons.Default.Public, Color(0xFF38BDF8)),
                    SubjectInfo("English", Icons.AutoMirrored.Filled.MenuBook, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("NDA Full Length Mock 1", "2 Papers • 900 Marks"),
                    MockTestInfo("GAT Specialist Test", "Focus on History & Geography", Color(0xFFF59E0B))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Trigonometry Basics", "DPP"),
                    PracticeSheetInfo("Current Affairs Digest", "Monthly"),
                    PracticeSheetInfo("NDA II 2023 Paper", "PYQ")
                )
            )
            "iat_nest" -> PremiumExamData(
                examName = "IAT & NEST",
                description = "For IISERs and NISER Research programs",
                bannerColors = listOf(Color(0xFF4F46E5), Color(0xFF4338CA)),
                subjects = listOf(
                    SubjectInfo("Biology", Icons.Default.Spa, Color(0xFF10B981)),
                    SubjectInfo("Physics", Icons.Default.FlashOn, Color(0xFFF59E0B)),
                    SubjectInfo("Chemistry", Icons.Default.Science, Color(0xFF38BDF8)),
                    SubjectInfo("Mathematics", Icons.Default.Functions, Color(0xFFEF4444))
                ),
                mockTests = listOf(
                    MockTestInfo("IAT Simulation 2024", "Research Based Questions"),
                    MockTestInfo("NEST Sectional Test", "Major in Bio/Math", Color(0xFF10B981))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Analytical Thinking", "DPP"),
                    PracticeSheetInfo("Modern Physics Lab", "Formula Sheet"),
                    PracticeSheetInfo("IAT 2023 Archive", "PYQ")
                )
            )
            "cuet_sci" -> PremiumExamData(
                examName = "CUET UG Science",
                description = "Admission to top Central Universities",
                bannerColors = listOf(Color(0xFF0369A1), Color(0xFF075985)),
                subjects = listOf(
                    SubjectInfo("Domain Subjects", Icons.Default.Category, Color(0xFF38BDF8)),
                    SubjectInfo("General Test", Icons.Default.Psychology, Color(0xFFF59E0B)),
                    SubjectInfo("Language", Icons.Default.Language, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("CUET Pattern Mock", "45 mins per subject"),
                    MockTestInfo("Section III: General", "Mental Ability Focus", Color(0xFFF59E0B))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("NCRT Summary", "Notes"),
                    PracticeSheetInfo("Logical Reasoning", "DPP"),
                    PracticeSheetInfo("CUET 2023 Samples", "PYQ")
                )
            )

            // --- COMMERCE STREAM ---
            "ca_foundation" -> PremiumExamData(
                examName = "CA Foundation",
                description = "Your first step to becoming a Chartered Accountant",
                bannerColors = listOf(Color(0xFF7C3AED), Color(0xFF5B21B6)),
                subjects = listOf(
                    SubjectInfo("Accounting", Icons.Default.Calculate, Color(0xFF10B981)),
                    SubjectInfo("Law", Icons.Default.Gavel, Color(0xFFF59E0B)),
                    SubjectInfo("Economics", Icons.AutoMirrored.Filled.TrendingUp, Color(0xFF38BDF8))
                ),
                mockTests = listOf(
                    MockTestInfo("ICAI Pattern Mock", "400 Marks • Subjective/Objective"),
                    MockTestInfo("Law Writing Practice", "Answer Evaluation Included", Color(0xFFF59E0B))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Partnership Accounts", "DPP"),
                    PracticeSheetInfo("Business Law Key Terms", "Cheat Sheet"),
                    PracticeSheetInfo("Nov 2023 Exam Paper", "PYQ")
                )
            )
            "cma_cseet" -> PremiumExamData(
                examName = "CMA & CSEET",
                description = "For future CMAs and Company Secretaries",
                bannerColors = listOf(Color(0xFFB91C1C), Color(0xFF991B1B)),
                subjects = listOf(
                    SubjectInfo("Costing", Icons.Default.AccountBalance, Color(0xFF10B981)),
                    SubjectInfo("Legal Aptitude", Icons.Default.Balance, Color(0xFF38BDF8)),
                    SubjectInfo("Current Affairs", Icons.Default.Public, Color(0xFFF59E0B))
                ),
                mockTests = listOf(
                    MockTestInfo("CSEET Online Simulation", "Viva-Voce included"),
                    MockTestInfo("CMA Foundation Mock", "Cost & Mgmt focus", Color(0xFF10B981))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Economic Laws", "Notes"),
                    PracticeSheetInfo("Costing Formulas", "Formula Sheet"),
                    PracticeSheetInfo("Last 5 Attempts", "PYQ")
                )
            )
            "ipmat_jipmat" -> PremiumExamData(
                examName = "IPMAT & JIPMAT",
                description = "Join IIMs right after Class 12",
                bannerColors = listOf(Color(0xFF15803D), Color(0xFF166534)),
                subjects = listOf(
                    SubjectInfo("Quant Aptitude", Icons.Default.Calculate, Color(0xFFF59E0B)),
                    SubjectInfo("Verbal Ability", Icons.Default.TextFields, Color(0xFF38BDF8)),
                    SubjectInfo("Data Interpretation", Icons.Default.BarChart, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("IPMAT Indore Mock", "Higher Math Focus"),
                    MockTestInfo("IPMAT Rohtak Mock", "Speed & Accuracy Test", Color(0xFF15803D))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Number Systems", "DPP"),
                    PracticeSheetInfo("Vocabulary Builder", "Daily"),
                    PracticeSheetInfo("IPMAT 2023 Memory", "PYQ")
                )
            )
            "cuet_com" -> PremiumExamData(
                examName = "CUET UG Commerce",
                description = "SRCC, Hindu and top Commerce colleges",
                bannerColors = listOf(Color(0xFFEA580C), Color(0xFFC2410C)),
                subjects = listOf(
                    SubjectInfo("Accountancy", Icons.Default.Analytics, Color(0xFF10B981)),
                    SubjectInfo("Business Studies", Icons.Default.BusinessCenter, Color(0xFFF59E0B)),
                    SubjectInfo("Economics", Icons.AutoMirrored.Filled.TrendingUp, Color(0xFF38BDF8))
                ),
                mockTests = listOf(
                    MockTestInfo("CUET Commerce Full Mock", "NTA Pattern Questions"),
                    MockTestInfo("Domain Subject Drill", "Accountancy Focus", Color(0xFFEA580C))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Macro Economics", "DPP"),
                    PracticeSheetInfo("Business Case Studies", "Notes"),
                    PracticeSheetInfo("2023 Solved Series", "PYQ")
                )
            )
            "set_christ" -> PremiumExamData(
                examName = "SET & Christ Entrance",
                description = "For Symbiosis and Christ University",
                bannerColors = listOf(Color(0xFF334155), Color(0xFF1E293B)),
                subjects = listOf(
                    SubjectInfo("Gen English", Icons.Default.MenuBook, Color(0xFF10B981)),
                    SubjectInfo("Gen Awareness", Icons.Default.Public, Color(0xFFF59E0B)),
                    SubjectInfo("Quant/LR", Icons.Default.Psychology, Color(0xFF38BDF8))
                ),
                mockTests = listOf(
                    MockTestInfo("SET Full Mock 2024", "Standard Difficulty"),
                    MockTestInfo("Christ Micro-Presentation", "Special Prep", Color(0xFFF59E0B))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Grammar Mastery", "DPP"),
                    PracticeSheetInfo("BBA Interview Tips", "Video Link"),
                    PracticeSheetInfo("Last Year SET Paper", "PYQ")
                )
            )

            // --- ARTS & HUMANITIES STREAM ---
            "cuet_arts" -> PremiumExamData(
                examName = "CUET UG Arts",
                description = "Top colleges for Humanities",
                bannerColors = listOf(Color(0xFFDB2777), Color(0xFFBE185D)),
                subjects = listOf(
                    SubjectInfo("History", Icons.Default.HistoryEdu, Color(0xFFF59E0B)),
                    SubjectInfo("Pol Science", Icons.Default.AccountBalance, Color(0xFF38BDF8)),
                    SubjectInfo("Psychology", Icons.Default.SelfImprovement, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("CUET Humanities Mock", "Domain + General Test"),
                    MockTestInfo("Language Proficiency", "English/Hindi Focus", Color(0xFFDB2777))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("World Map Practice", "DPP"),
                    PracticeSheetInfo("Constitutional Articles", "Cheat Sheet"),
                    PracticeSheetInfo("CUET 2023 Archive", "PYQ")
                )
            )
            "clat_ailet" -> PremiumExamData(
                examName = "CLAT & AILET",
                description = "For NLUs and premier Law colleges",
                bannerColors = listOf(Color(0xFF1E1B4B), Color(0xFF312E81)),
                subjects = listOf(
                    SubjectInfo("Legal Reasoning", Icons.Default.Gavel, Color(0xFFF59E0B)),
                    SubjectInfo("Current Affairs", Icons.Default.Language, Color(0xFF38BDF8)),
                    SubjectInfo("Logical Reasoning", Icons.Default.Psychology, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("CLAT Full Mock", "120 Qs • Comprehensive"),
                    MockTestInfo("AILET Specialist Test", "High Difficulty", Color(0xFF312E81))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Torts & Contracts", "DPP"),
                    PracticeSheetInfo("Legal Maxim Guide", "Formula Sheet"),
                    PracticeSheetInfo("CLAT 2023 Analysis", "PYQ")
                )
            )
            "nid_dat" -> PremiumExamData(
                examName = "NID DAT",
                description = "Top Design Institute Entrance",
                bannerColors = listOf(Color(0xFF4338CA), Color(0xFF3730A3)),
                subjects = listOf(
                    SubjectInfo("Creativity", Icons.Default.Palette, Color(0xFFEF4444)),
                    SubjectInfo("Visual Perf", Icons.Default.Brush, Color(0xFFF59E0B)),
                    SubjectInfo("Aptitude", Icons.Default.Lightbulb, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("DAT Prelims Mock", "Sketching + MCQ"),
                    MockTestInfo("Studio Test Prep", "Advanced Round", Color(0xFF4338CA))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Perspective Drawing", "Practice"),
                    PracticeSheetInfo("Color Theory Basics", "Notes"),
                    PracticeSheetInfo("NID 2022 Portfolio", "Samples")
                )
            )
            "nift" -> PremiumExamData(
                examName = "NIFT Entrance",
                description = "Leading Fashion Technology Exam",
                bannerColors = listOf(Color(0xFF059669), Color(0xFF047857)),
                subjects = listOf(
                    SubjectInfo("Creative Ability", Icons.Default.Checkroom, Color(0xFFF59E0B)),
                    SubjectInfo("General Ability", Icons.Default.Public, Color(0xFF38BDF8)),
                    SubjectInfo("English", Icons.Default.Language, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("NIFT CAT/GAT Mock", "Design + GAT Analysis"),
                    MockTestInfo("Situation Test", "Material Handling", Color(0xFF059669))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Fabric Studies", "Notes"),
                    PracticeSheetInfo("Design Composition", "DPP"),
                    PracticeSheetInfo("NIFT PYQ Bundle", "PYQ")
                )
            )
            "nata_jee_p2" -> PremiumExamData(
                examName = "NATA & JEE Main P2",
                description = "For Architecture Aspirants",
                bannerColors = listOf(Color(0xFF475569), Color(0xFF334155)),
                subjects = listOf(
                    SubjectInfo("Drawing", Icons.Default.Architecture, Color(0xFFEF4444)),
                    SubjectInfo("Aptitude", Icons.Default.Visibility, Color(0xFF38BDF8)),
                    SubjectInfo("Mathematics", Icons.Default.Functions, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("NATA Drawing Test", "Timed Sketching Round"),
                    MockTestInfo("JEE Main Paper 2", "Math + Drawing + Apti", Color(0xFF475569))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("3D Visualization", "Practice"),
                    PracticeSheetInfo("Arch Formulas", "Cheat Sheet"),
                    PracticeSheetInfo("NATA 2023 Archive", "PYQ")
                )
            )

            // --- AFTER GRADUATION EXAMS ---
            
            // SCIENCE (POST-GRAD)
            "gate" -> PremiumExamData(
                examName = "GATE",
                description = "Graduate Aptitude Test in Engineering",
                bannerColors = listOf(Color(0xFF1E3A8A), Color(0xFF1E40AF)),
                subjects = listOf(
                    SubjectInfo("Core Engineering", Icons.Default.Settings, Color(0xFFF59E0B)),
                    SubjectInfo("Eng. Mathematics", Icons.Default.Functions, Color(0xFF10B981)),
                    SubjectInfo("General Aptitude", Icons.Default.Psychology, Color(0xFF38BDF8))
                ),
                mockTests = listOf(
                    MockTestInfo("GATE Full Mock 2024", "Virtual Calculator Enabled"),
                    MockTestInfo("Sectional Practice", "Topic-wise focus", Color(0xFF38BDF8))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Technical DPP", "DPP"),
                    PracticeSheetInfo("Math Summary", "Formula Sheet"),
                    PracticeSheetInfo("15-Year PYQ Bank", "PYQ")
                )
            )
            "jam" -> PremiumExamData(
                examName = "IIT JAM",
                description = "Joint Admission Test for Masters",
                bannerColors = listOf(Color(0xFF0369A1), Color(0xFF075985)),
                subjects = listOf(
                    SubjectInfo("Major Subject", Icons.Default.Science, Color(0xFF10B981)),
                    SubjectInfo("Practical Theory", Icons.Default.FilterFrames, Color(0xFFF59E0B)),
                    SubjectInfo("Problem Solving", Icons.Default.FlashOn, Color(0xFFEF4444))
                ),
                mockTests = listOf(
                    MockTestInfo("JAM Subject Mock", "IIT Pattern Questions"),
                    MockTestInfo("Section A Practice", "Objective Focused", Color(0xFF0369A1))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Concept Worksheets", "DPP"),
                    PracticeSheetInfo("Subject Key Points", "Notes"),
                    PracticeSheetInfo("JAM Solved Papers", "PYQ")
                )
            )
            "csir_net" -> PremiumExamData(
                examName = "CSIR NET",
                description = "Council of Scientific and Industrial Research NET",
                bannerColors = listOf(Color(0xFF065F46), Color(0xFF064E3B)),
                subjects = listOf(
                    SubjectInfo("Core Science", Icons.Default.Dns, Color(0xFF10B981)),
                    SubjectInfo("Research Methodology", Icons.Default.Science, Color(0xFF38BDF8)),
                    SubjectInfo("General Aptitude", Icons.Default.Psychology, Color(0xFFF59E0B))
                ),
                mockTests = listOf(
                    MockTestInfo("CSIR NET Full Test", "Research Level Complexity"),
                    MockTestInfo("Part A Specialist", "General Sci & Reasoning", Color(0xFF065F46))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Advanced DPP", "Daily"),
                    PracticeSheetInfo("CSIR PYQ Module", "PYQ")
                )
            )

            // COMMERCE (POST-GRAD / PROF)
            "cat" -> PremiumExamData(
                examName = "CAT",
                description = "Common Admission Test for IIMs",
                bannerColors = listOf(Color(0xFF15803D), Color(0xFF166534)),
                subjects = listOf(
                    SubjectInfo("VARC", Icons.Default.TextFields, Color(0xFFF59E0B)),
                    SubjectInfo("DILR", Icons.Default.BarChart, Color(0xFF38BDF8)),
                    SubjectInfo("Quants", Icons.Default.Calculate, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("SimCAT 2024", "Full Analysis Dashboard"),
                    MockTestInfo("Sectional Drill", "Time-pressure mode", Color(0xFF15803D))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Quant Shortcuts", "Formula Sheet"),
                    PracticeSheetInfo("RC Passages", "Daily Practice"),
                    PracticeSheetInfo("CAT 2023 Analysis", "PYQ")
                )
            )
            "xat" -> PremiumExamData(
                examName = "XAT",
                description = "Xavier Aptitude Test",
                bannerColors = listOf(Color(0xFF4338CA), Color(0xFF3730A3)),
                subjects = listOf(
                    SubjectInfo("Decision Making", Icons.Default.QuestionAnswer, Color(0xFFF59E0B)),
                    SubjectInfo("Verbal Ability", Icons.Default.Language, Color(0xFF38BDF8)),
                    SubjectInfo("Quant & DI", Icons.Default.Calculate, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("XAT Full Mock", "Includes DM & GK sections"),
                    MockTestInfo("Decision Making Drill", "Ethics Focused", Color(0xFF4338CA))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("DM Logic Sheets", "DPP"),
                    PracticeSheetInfo("GK Monthly Capsule", "Notes")
                )
            )
            "ca_final" -> PremiumExamData(
                examName = "CA Final",
                description = "Final Stage of Chartered Accountancy",
                bannerColors = listOf(Color(0xFF7C3AED), Color(0xFF5B21B6)),
                subjects = listOf(
                    SubjectInfo("FR & SFM", Icons.Default.AccountBalance, Color(0xFF10B981)),
                    SubjectInfo("Audit & Law", Icons.Default.Gavel, Color(0xFFF59E0B)),
                    SubjectInfo("Direct/Indirect Tax", Icons.Default.Calculate, Color(0xFF38BDF8))
                ),
                mockTests = listOf(
                    MockTestInfo("ICAI Pattern Mock", "Subjective Evaluation"),
                    MockTestInfo("Case Study Test", "Elective Special", Color(0xFF7C3AED))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("LMR (Last Min Rev)", "Cheat Sheet"),
                    PracticeSheetInfo("RTP & MTP Archive", "Practice"),
                    PracticeSheetInfo("Nov 2023 Paper", "PYQ")
                )
            )
            "cs_final" -> PremiumExamData(
                examName = "CS Final",
                description = "Company Secretary Final Level",
                bannerColors = listOf(Color(0xFFB91C1C), Color(0xFF991B1B)),
                subjects = listOf(
                    SubjectInfo("Corporate Law", Icons.Default.Gavel, Color(0xFF10B981)),
                    SubjectInfo("Governance & Ethics", Icons.Default.MenuBook, Color(0xFF38BDF8)),
                    SubjectInfo("Due Diligence", Icons.Default.Security, Color(0xFFF59E0B))
                ),
                mockTests = listOf(
                    MockTestInfo("CS Professional Mock", "Subjective Exam Focus"),
                    MockTestInfo("Ethical Case Review", "Writing Practice", Color(0xFFB91C1C))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Case Law Index", "Notes"),
                    PracticeSheetInfo("Amendment Sheet", "Monthly"),
                    PracticeSheetInfo("CS PYQ Bank", "PYQ")
                )
            )

            // ARTS (POST-GRAD / GOVT)
            "upsc_cse" -> PremiumExamData(
                examName = "UPSC CSE",
                description = "Union Public Service Commission Civil Services",
                bannerColors = listOf(Color(0xFFEA580C), Color(0xFFC2410C)),
                subjects = listOf(
                    SubjectInfo("General Studies", Icons.Default.Public, Color(0xFF38BDF8)),
                    SubjectInfo("Current Affairs", Icons.Default.Language, Color(0xFFF59E0B)),
                    SubjectInfo("Optional Subject", Icons.Default.Category, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("Prelims GS Paper I", "Full GS Coverage"),
                    MockTestInfo("CSAT Aptitude Test", "Speed & Accuracy", Color(0xFFEA580C))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("NCERT Gist", "Notes"),
                    PracticeSheetInfo("Daily News Analysis", "DPP"),
                    PracticeSheetInfo("Mains Answer Writing", "Practice")
                )
            )
            "ugc_net" -> PremiumExamData(
                examName = "UGC NET",
                description = "Assistant Professor & JRF eligibility",
                bannerColors = listOf(Color(0xFFDB2777), Color(0xFFBE185D)),
                subjects = listOf(
                    SubjectInfo("Paper I: Teaching", Icons.Default.School, Color(0xFFF59E0B)),
                    SubjectInfo("Domain Subject", Icons.Default.MenuBook, Color(0xFF38BDF8)),
                    SubjectInfo("Research Aptitude", Icons.Default.Science, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("NTA Pattern Mock", "Paper I + II combined"),
                    MockTestInfo("Logical Reasoning Drill", "Paper I Special", Color(0xFFDB2777))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Teaching Concepts", "DPP"),
                    PracticeSheetInfo("UGC 10-Year PYQ", "PYQ")
                )
            )
            "tissnet" -> PremiumExamData(
                examName = "TISSNET",
                description = "Tata Institute of Social Sciences NET",
                bannerColors = listOf(Color(0xFF0369A1), Color(0xFF075985)),
                subjects = listOf(
                    SubjectInfo("Social Awareness", Icons.Default.Groups, Color(0xFF38BDF8)),
                    SubjectInfo("Analytical Ability", Icons.Default.Psychology, Color(0xFFF59E0B)),
                    SubjectInfo("English Proficiency", Icons.Default.Language, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("TISSNET Full Mock", "High GK Weightage"),
                    MockTestInfo("Social GK Specialist", "Social Sector Focus", Color(0xFF0369A1))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Current Issues", "Monthly Capsule"),
                    PracticeSheetInfo("Quant for Arts", "DPP")
                )
            )
            "cuet_pg" -> PremiumExamData(
                examName = "CUET PG",
                description = "Masters Entrance for Central Universities",
                bannerColors = listOf(Color(0xFF475569), Color(0xFF334155)),
                subjects = listOf(
                    SubjectInfo("Domain Knowledge", Icons.Default.Class, Color(0xFF38BDF8)),
                    SubjectInfo("General Paper", Icons.Default.MenuBook, Color(0xFFF59E0B)),
                    SubjectInfo("Part A Aptitude", Icons.Default.Psychology, Color(0xFF10B981))
                ),
                mockTests = listOf(
                    MockTestInfo("CUET PG Simulation", "New NTA Pattern"),
                    MockTestInfo("Sectional Subject Mock", "Domain Specific", Color(0xFF475569))
                ),
                practiceSheets = listOf(
                    PracticeSheetInfo("Core Theory Gist", "Notes"),
                    PracticeSheetInfo("CUET 2023 Solved", "PYQ")
                )
            )
            else -> null
        }
    }
}
