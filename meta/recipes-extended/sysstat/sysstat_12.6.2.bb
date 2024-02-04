require sysstat.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a23a74b3f4caf9616230789d94217acb"

SRC_URI += "file://0001-configure.in-remove-check-for-chkconfig.patch \
            file://CVE-2023-33204.patch \
            "

SRC_URI[sha256sum] = "3fa748117f6fb824cfc068dac2484b1b7f2630a9317a7ce3c0bbcad606ca1a30"
