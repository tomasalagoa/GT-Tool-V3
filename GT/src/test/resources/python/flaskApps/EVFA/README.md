Files present here are from the following Github repo: https://github.com/manuelz120/extremely-vulnerable-flask-app

For future reference, here are the vulnerabilities found from files in routes directory:
        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "update_account",
        "fileName" : "account.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 50 - 53 - 63 - 65. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 65,
            "vulnerableMethod" : "merge",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "add_image",
        "fileName" : "account.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 35 - 38 - 41 - 42 - 50 - 53 - 63 - 65. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 42,
            "vulnerableMethod" : "merge",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "get_personal_notes",
        "fileName" : "account.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 28 - 29 - 35 - 38 - 41 - 42 - 50 - 53 - 63 - 65. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 28,
            "vulnerableMethod" : "filter",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "account",
        "fileName" : "account.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "toggle_darkmode",
        "fileName" : "account.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "signup",
        "fileName" : "signup.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "do_signup",
        "fileName" : "signup.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 28 - 29 - 32 - 35 - 38 - 41 - 42 - 50 - 51 - 53 - 57 - 59 - 63 - 65. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 51,
            "vulnerableMethod" : "delete",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        }, {
            "line" : 46,
            "vulnerableMethod" : "get",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        }, {
            "line" : 38,
            "vulnerableMethod" : "where",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        }, {
            "line" : 15,
            "vulnerableMethod" : "execute",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        }, {
            "line" : 59,
            "vulnerableMethod" : "add",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "get_notes",
        "fileName" : "notes.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "delete_note",
        "fileName" : "notes.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 28 - 29 - 32 - 35 - 38 - 39 - 41 - 42 - 43 - 50 - 51 - 53 - 57 - 59 - 63 - 65. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 39,
            "vulnerableMethod" : "get",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        }, {
            "line" : 43,
            "vulnerableMethod" : "delete",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "add_note",
        "fileName" : "notes.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 19 - 22 - 25 - 26 - 28 - 29 - 32 - 35 - 38 - 39 - 41 - 42 - 43 - 50 - 51 - 53 - 57 - 59 - 63 - 65. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 26,
            "vulnerableMethod" : "add",
            "functionCallStack" : [ ],
            "conditions" : [ ]
        } ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "logout",
        "fileName" : "login.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "login",
        "fileName" : "login.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "logged_in",
        "fileName" : "login.py",
        "unknownMethodWarning" : null,
        "vulnerabilities" : [ ],
        "timeToProcessMilliseconds" : 0,
        "timeToProcessFramework" : 0
        }

        {
        "frameworkMessage" : "This is a report on Flask framework analysis. Please note the processed time is on the last entry",
        "analyzedFunctionName" : "do_login",
        "fileName" : "login.py",
        "unknownMethodWarning" : "Unknown methods/functions (i.e method/function with an unreachable code block) with tainted argument(s) have been found in lines 19 - 22 - 24 - 25 - 26 - 27 - 28 - 29 - 30 - 32 - 35 - 38 - 39 - 41 - 42 - 43 - 50 - 51 - 53 - 57 - 59 - 63 - 65. As the tool's current unknown method detection is a bit simplified, please check if the vulnerabilities that arised from that detection are true vulnerabilities.",
        "vulnerabilities" : [ {
            "line" : 30,
            "vulnerableMethod" : "filter",
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
        "timeToProcessMilliseconds" : 7406,
        "timeToProcessFramework" : 0
        }

