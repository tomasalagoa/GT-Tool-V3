Files present here are from the following Github repo: https://github.com/we45/Vulnerable-Flask-App

- For future reference, here are the vulnerabilities found in this file:
        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "reg_customer",
        "fileName" : "app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 23 - 24 - 25. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 25,
            "vulnerableMethod" : "add",
            "functionCallStack" : [ ],
            "conditions" : [ {
            "line" : 20,
            "condition" : "content"
            } ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "get_customer",
        "fileName" : "app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 23 - 24 - 25 - 113. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 113,
            "vulnerableMethod" : "get",
            "functionCallStack" : [ ],
            "conditions" : [ {
            "line" : 112,
            "condition" : "cust_id"
            } ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "search_customer",
        "fileName" : "app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 23 - 24 - 25 - 113 - 142 - 147. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 147,
            "vulnerableMethod" : "execute",
            "functionCallStack" : [ ],
            "conditions" : [ {
            "line" : 139,
            "condition" : "content"
            } ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "reg_user",
        "fileName" : "app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 23 - 24 - 25 - 43 - 44 - 113 - 142 - 147. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 44,
            "vulnerableMethod" : "add",
            "functionCallStack" : [ ],
            "conditions" : [ {
            "line" : 36,
            "condition" : "content"
            } ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "index",
        "fileName" : "app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "hello",
        "fileName" : "app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "yaml_upload",
        "fileName" : "app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "login",
        "fileName" : "app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 23 - 24 - 25 - 43 - 44 - 61 - 64 - 66 - 67 - 113 - 142 - 147. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 64,
            "vulnerableMethod" : "filter_by",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "sitemap",
        "fileName" : "app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "yaml_hammer",
        "fileName" : "app.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "fetch_customer",
        "fileName" : "app.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 23 - 24 - 25 - 43 - 44 - 61 - 64 - 66 - 67 - 90 - 113 - 142 - 147. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 90,
            "vulnerableMethod" : "get",
            "functionCallStack" : [ ],
            "conditions" : [ {
            "line" : 88,
            "condition" : "content"
            } ]
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
        "timeToProcessMilliseconds" : 4923,
        "timeToProcessFramework" : 0
        }
