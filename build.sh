#!/bin/bash

git submodule update --init --recursive --remote

chmod +x $(pwd)/buildtools/environment-setup-x86_64-pokysdk-linux
$(pwd)/buildtools/environment-setup-x86_64-pokysdk-linux
export PATH=$PATH:$(pwd)/buildtools/sysroots/x86_64-pokysdk-linux/usr/bin
export PATH=$PATH:$(pwd)/bitbake/bin

cd build

log="yocto.log"
echo "Yocto build started at" |& tee $log
date |& tee -a $log
echo -e "*****************************\n" |& tee -a $log

bitbake core-image-minimal |& tee -a $log

rm -f ~/yocto_intel_wic.gz
echo -e "\nZipping up WIC image"
pv ./tmp/deploy/images/arria10/core-image-minimal-arria10-*.rootfs.wic | gzip -fckN9 > ~/yocto_intel_wic.gz

echo -e "\nYocto build finished at" |& tee -a $log
date |& tee -a $log

