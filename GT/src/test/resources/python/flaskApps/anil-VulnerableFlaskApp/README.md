Files present here are from the following Github repo: https://github.com/anil-yelken/Vulnerable-Flask-App

For future reference, here are the vulnerabilities found:
        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "get_log",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "create_file",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 106 - 107. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 107,
            "vulnerableMethod" : "write",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        }, {
            "line" : 106,
            "vulnerableMethod" : "open",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "welcome2",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "user_pass_control",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "deserialization",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "get_users",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 35 - 38 - 106 - 107. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 35,
            "vulnerableMethod" : "check_output",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "get_admin_mail",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "welcome",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "search_user",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 11 - 12 - 16 - 35 - 38 - 106 - 107. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 11,
            "vulnerableMethod" : "execute",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "read_file",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 11 - 12 - 16 - 35 - 38 - 54 - 58 - 59 - 106 - 107. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 54,
            "vulnerableMethod" : "open",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "run_file",
        "fileName" : "vulnerable-flask-app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 11 - 12 - 16 - 35 - 38 - 54 - 58 - 59 - 96 - 106 - 107. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 96,
            "vulnerableMethod" : "check_output",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : null,
        "analyzedFunctionName" : null,
        "fileName" : null,
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 5033,
        "timeToProcessFramework" : 0
        }

